
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 -- 涉及到root to leaf的判断，注意leaf nodes怎么判断。题目应该是保证计算sum时不会overflow. DFS方法
// 时间复杂度: O(n)
// 空间复杂度: O(h)

public class Solution {
    public int sumNumbers(TreeNode root) {
        if( root == null ){
        	return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        dfs(root, res, 0);
        return res.get(0);
    }

    private void dfs(TreeNode root, ArrayList<Integer> res, int sum){
    	if( root == null ){
    		return;
    	}
    	sum = sum * 10 + root.val;
    	dfs(root.left, res, sum);
    	dfs(root.right, res, sum);
    	if( root.left == null && root.right == null ){
    		res.set(0, res.get(0) + sum);
    	}
    }
}

// Solution 2 -- 用字符串来拼接每个数字，最后用Integer.parseInt()来计算得到数值。
public class Solution {
    public int sumNumbers(TreeNode root) {
        if( root == null ){
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        dfs(res, root, "");
        return res.get(0);
    }
    
    private void dfs(ArrayList<Integer> res, TreeNode root, String temp){
        if( root == null ){
            return;
        }
        temp += root.val;
        dfs(res, root.left, temp);
        dfs(res, root.right, temp);
        if( root.left == null && root.right == null ){
            res.set(0, res.get(0)+Integer.parseInt(temp));    
        }
    }
}
