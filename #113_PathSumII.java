// Solution 1 --- DFS递归回溯, 注意是找root-to-leaf path !!!!! 注意节点元素值不一定都为正！！！注意回溯时的解集恢复！！
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度，即消耗的递归深度，不算解集空间。

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null ){
        	return result;
        }
        List<Integer> eachPath = new ArrayList<Integer>();
        dfs(root, result, eachPath, sum);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> eachPath, int sum){
    	if( root == null ){
    		return;
    	}
    	/* 注意！！！不要有下面这个判断，因为节点元素值和sum不一定为正！！！！
    	if( sum < 0 ){
    		return;
    	}
    	*/
    	eachPath.add(root.val);
    	int tmp = sum - root.val;
    	dfs(root.left, result, eachPath, tmp);
    	dfs(root.right, result, eachPath, tmp);
    	if( root.left == null && root.right == null ){
    		if( tmp == 0 ){
    			result.add( new ArrayList<Integer>(eachPath) );
    		}
    	}
    	eachPath.remove( eachPath.size() - 1 );
    }

}
