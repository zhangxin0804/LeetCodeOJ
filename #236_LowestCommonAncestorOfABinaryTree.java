/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 --- 递归中嵌套递归即双重递归方法，其中一个辅助递归函数是boolean帮助判断用的。
// 时间复杂度: O(nlogn)
// 空间复杂度: O(logn)

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null ){
        	return null;
        }
        if( root == p || root == q ){
        	return root == p?p:q;
        }
        // root != p && root != q
        boolean hasNode1 = hasNode(root.left, p);
        boolean hasNode2 = hasNode(root.right, q);
        // 注意第一个if分支的条件，可能p在left, q在right, 也可能p不在left(在right), q不在right(在left)
        // 注意if elseif的分支顺序是有讲究的，不能顺便调换。
        if( hasNode1 && hasNode2 || !hasNode1 && !hasNode2 ){
        	return root;
        }else if( !hasNode2 ){
        	return lowestCommonAncestor(root.left, p, q);
        }else{
			return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    private boolean hasNode(TreeNode root, TreeNode target){
    	if( root == null ){
    		return false;
    	}
    	if( root == target ){
    		return true;
    	}
    	return hasNode(root.left, target) || hasNode(root.right, target);
    }
}


// Solution 2  -- 通过改变返回值类型，将双重递归合并成单递归来提速。合并的前提是，合并后的这单个函数能够表达的含义和完成的功能,
//                等价于之前双重递归的功能。那么下面合并后的单递归，其实就是自顶向下去寻找树中的p或者q, 能找到的话就不断从下往上
//                return回去具体的Node, 找不到的话就是return null, 再根据从左右子树return回来的结果，进行处理进一步判断LCA
//                然后不断继续return回去。
// 时间复杂度: O(n)
// 空间复杂度: O(logn)

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // assume p and q in tree and not equal to null
        if( root == null ){
            return null;
        }
        if( root == p || root == q ){
            return root;
        }
        TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFind = lowestCommonAncestor(root.right, p, q);
        if( leftFind != null && rightFind != null ){
            return root;
        }else if( leftFind == null && rightFind == null ){
            return null;
        }else if( leftFind != null ){
            return leftFind;
        }else{
            return rightFind;
        }
    }
}
