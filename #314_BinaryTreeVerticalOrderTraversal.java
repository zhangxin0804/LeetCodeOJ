/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
解析: 
	这个题最初分析的时候，想考虑利用DFS遍历传递order信息，然后利用HashMap存储对应order以及其list, 但是发现DFS的话会造成乱序。因为比如，
DFS往右下探测到新的Order然后添加了元素，但是这个元素如果从top to bottom来看的话，顺序就不对了！！
	仔细看题目，题目要求输出结果按照 left to right和top to bottom的顺序来输出，因此应该联想到BFS的level order才对！！！还是利用
HashMap存储对应order以及其list, 我们要想办法把每个node对应的order信息传递下去，这样才能得到新的node的相对Order, 因此可以考虑再利用
一个队列即存储Order信息的,它是对应遍历的queue的。因此每次poll出一个新的node, 也poll出一个该node的Order, 然后加入新的child node, 以及
加入新的child nodes的Order. 再遍历过程中，同时维护order的左右边界，这样方便最后遍历这个range得到map中对应order的对应list. 
*/

// Solution 1 --- BFS, 多存一组order信息对应BFS遍历，保证left to right, top to bottom的Order, 维护order的左右边界。
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( root == null ){
        	return res;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();// 遍历queue
        Queue<Integer> order = new LinkedList<Integer>(); // 对应遍历queue的存储order的queue
        int leftBound = Integer.MAX_VALUE; // 维护order的左右边界，方便最后遍历。
        int rightBound = Integer.MIN_VALUE;
        queue.offer(root); // 成对儿操作
        order.offer(0);
        while( !queue.isEmpty() ){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode crt = queue.poll(); 
        		int crtOrder = order.poll(); // 成对儿操作。

        		if( map.containsKey(crtOrder) ){
        			map.get(crtOrder).add(crt.val);
        		}else{
        			List<Integer> each = new ArrayList<Integer>();
        			each.add(crt.val);
        			map.put(crtOrder, each);
        		}
        		// 更新order的左右边界值。
        		leftBound = Math.min(crtOrder, leftBound);
        		rightBound = Math.max(crtOrder, rightBound);
        		if( crt.left != null ){
        			queue.offer(crt.left);
        			order.offer(crtOrder-1);
        		}
        		if( crt.right != null){
        			queue.offer(crt.right);
        			order.offer(crtOrder+1);
        		}
        	}
        }
        // 遍历Order的range, 添加结果。
        for(int i = leftBound; i <= rightBound; i++){
        	res.add(map.get(i));
        }
        return res;
    }
}
