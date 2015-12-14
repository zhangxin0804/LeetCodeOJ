// Solution 1 --- 传统DFS方法，用ArrayList<>维护全局的minDepth, 注意判断leaf node以及更新minDepth
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度递归深度。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if( root == null ){
        	return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MAX_VALUE);
        dfs(root, 0, res);
        return 
    }

    private void dfs(TreeNode root, int height, ArrayList<Integer> res){
    	if( root == null ){
    		return;
    	}
    	height += 1;
    	dfs(root.left, height, res);
    	dfs(root.right, height, res);
    	if( root.left == null && root.right == null ){
    		res.set( 0, Math.min(height, res.get(0)) );
    	}
    }
}

// Solution 2 -- 带返回值的分治递归divide & conquer方法, 注意这个题目，找min depth是找一条root to leaf的path.
//               所以我们要考虑如果某个root的一边为null, 另一边不为null时的特殊处理，不能直接返回Math.min()+1, 因为
//               为null的一边根本构不成root to leaf的path.
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度递归深度。

public class Solution {
    public int minDepth(TreeNode root) {
        if( root == null ){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if( root.left == null && root.right != null ){
            return right + 1;
        }
        if( root.left != null && root.right == null ){
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }
}
