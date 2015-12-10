// Solution 1 ---- DFS + 维护一个类似全局变量
// 时间复杂度: O(n)
// 空间复杂度: O(h)

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ){
        	return false;
        }
        ArrayList<Boolean> res = new ArrayList<Boolean>();
        res.add(false);
        dfs(root, sum, res);
        return res.get(0);
    }

    private void dfs(TreeNode root, int sum, ArrayList<Boolean> res ){

    	if( root == null ){
    		return;
    	}
    	// 类似维护一个全局的布尔变量表示是否找到root-to-leaf这样一条path满足sum = 0
    	// 如果找到了，就会更新boolean值，之后在递归时直接用于作为递归终止的判断。
        // 下面的判断也可以不要。
    	if(res.get(0)){
    		return;
    	}
    	sum = sum - root.val;
    	dfs(root.left, sum, res);
    	dfs(root.right, sum, res);
    	if( root.left == null && root.right == null ){
    		if( sum == 0 ){
    			res.set(0, true);
    		}
    	}
    }
}

// Solution 2 --- 带返回值的递归，即 分治递归 divide & conquer方法
// 时间复杂度: O(n)
// 空间复杂度: O(h)

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ){
        	return false;
        }
        if( root.left == null && root.right == null ){
        	if( sum == root.val ){
        		return true;
        	}
        	return false;
        }
        sum = sum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
