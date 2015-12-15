
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1 --- recursive方法，即 分治递归 divide and conquer
// 时间复杂度: O(n), n为所有Nodes数目。
// 空间复杂度: O(h), h是树的高度

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
    	if( root == null ){
    		return null;
    	}
    	TreeNode leftInv = invertTree(root.left);
    	TreeNode rightInv = invertTree(root.right);
    	root.left = rightInv;
    	root.right = leftInv;
    	return root;
    }
}

// Solution 2 --- iterative方法, 按照BFS一层一层往下遍历，同时一边遍历一边Invert 左右
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if( root == null ){
        	return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode crt = queue.poll();
        		TreeNode tmp = crt.left;
        		crt.left = crt.right;
        		crt.right = tmp;
        		if( crt.left != null ){
        			queue.offer(crt.left);
        		}
        		if( crt.right != null ){
        			queue.offer(crt.right);
        		}
        	}
        }
        return root;
    }
}
