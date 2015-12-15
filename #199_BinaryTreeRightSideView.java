/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 --- BFS遍历，每次都会保存好下一个level的nodes, 因此返回下一个level的最后一个Node加入解集即可。
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if( root == null ){
        	return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode crt = queue.poll();
        		if( crt.left != null ){
        			queue.offer(crt.left);
        		}
        		if( crt.right != null ){
        			queue.offer(crt.right);
        		}
        		if( i == size - 1 ){
        			res.add(crt.val);
        		}
        	}
        }
    	return res;
    }
}

// Solution 2 ---- DFS, 常规DFS遍历维护level层数，然后用额外空间存储每一层元素，最后遍历每一层取出最后一个元素，加入解集。
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if( root == null ){
        	return res;
        }
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        dfs(root, 1, levelList);
        for(int i = 0; i < levelList.size(); i++){
        	ArrayList<Integer> eachLevel = levelList.get(i);
        	res.add(eachLevel.get(eachLevel.size()-1));
        }
        return res;
    }

    private void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> levelList){
    	if( root == null ){
    		return;
    	}
    	if( level > levelList.size() ){
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(root.val);
    		levelList.add(temp);
    	}else{
    		levelList.get(level-1).add(root.val);
    	}
    	dfs(root.left, level+1, levelList);
    	dfs(root.right, level+1, levelList);
    }

}
