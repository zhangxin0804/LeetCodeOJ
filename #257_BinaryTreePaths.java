/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 ---- 典型DFS题目，注意仍然是要处理root to leaft的path, 字符串作为参数时的递归回溯，可以自然返回。
// 时间复杂度: O(n), 忽略掉字符串在拼接时，是创建新的字符串再copy的过程的时间消耗。
// 空间复杂度: O(h)

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<String>();
        if( root == null ){
        	return res;
        }
        dfs(res, root, "");
        return res;
    }

    private void dfs(List<String> res, TreeNode root, String path){
    	if( root == null ){
    		return;
    	}
    	path += root.val;
    	if( root.left == null && root.right == null ){
    		res.add(path);
    		return;
    	}
    	dfs(res, root.left, path + "->");
    	dfs(res, root.right, path + "->");
    }
}
