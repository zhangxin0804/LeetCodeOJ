// Solution 1   ---- recursive递归法, 根左右
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度

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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
        	return result;
        }
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result){
    	if( root == null ){
    		return;
    	}
    	result.add(root.val);
    	dfs(root.left, result);
    	dfs(root.right, result);
    }
}

// Solution 2 ---- 循环迭代法, 利用堆栈stack
// 时间复杂度: O(n)
// 空间复杂度: O(n)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
        	return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while( !stack.empty() ){
        	TreeNode tmp = stack.pop();
        	result.add(tmp.val);
        	if( tmp.right != null ){
        		stack.push(tmp.right);
        	}
        	if( tmp.left != null ){
        		stack.push(tmp.left);
        	}
        }
        return result;
    }
}
