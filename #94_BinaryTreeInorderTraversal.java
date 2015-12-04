// Solution 1  ---- 递归解法
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
    public List<Integer> inorderTraversal(TreeNode root) {
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
    	dfs(root.left, result);
    	result.add(root.val);
    	dfs(root.right, result);
    }
}



// Solution 2  ---- 非递归解法，堆栈stack辅助
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
        	return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode crt = root;
        while( crt != null || !stack.empty() ){
        	while( crt != null ){
        		stack.push(crt);
        		crt = crt.left;
        	}
        	TreeNode tmp = stack.pop();
        	result.add(tmp.val);
        	crt = tmp.right;
        }
        return result;
    }
}
