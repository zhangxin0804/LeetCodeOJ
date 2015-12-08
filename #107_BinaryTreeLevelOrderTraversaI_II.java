/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 2 --- 利用Collections.reverse()这个API.
// 时间复杂度: O(n)
// 空间复杂度: O(2^(h-1)), h为满二叉树的高度

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( root == null ){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            int size = queue.size();
            List<Integer> eachLevel = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode crt = queue.poll();
                eachLevel.add(crt.val);
                if( crt.left != null ){
                    queue.offer(crt.left);
                }
                if( crt.right != null ){
                    queue.offer(crt.right);
                }
            }
            res.add(eachLevel);
        }
        Collections.reverse(res);
        
        return res;
    }
}

// Solution 1 --- 利用LinkedList作为collection来存储结果，顺序遍历每一层结果，然后往头部insert
// 时间复杂度: O(n)
// 空间复杂度: O(2^(h-1)), h为满二叉树的高度

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if( root == null ){
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while( !queue.isEmpty() ){
    		int size = queue.size();
    		List<Integer> eachLevel = new ArrayList<Integer>();
    		for(int i = 0; i < size; i++){
    			TreeNode tmp = queue.poll();
    			eachLevel.add(tmp.val);
    			if( tmp.left != null ){
    				queue.offer(tmp.left);
    			}
    			if( tmp.right != null ){
    				queue.offer(tmp.right);
    			}
    		}
    		result.add(0,eachLevel);
            //((LinkedList)result).addFirst(eachLevel);
    	}
	    return result;
    }
}
