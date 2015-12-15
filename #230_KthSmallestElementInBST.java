/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1  --- 可以先将BST进行中序遍历，存入一个数组，然后再遍历数组找到第kth小的元素即可。
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if( root == null ){
            return 0;
        }   
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode crt = root;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while( crt != null || !stack.empty() ){
            while( crt != null ){
                stack.push(crt);
                crt = crt.left;
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            crt = tmp.right;
        }
        return res.get(k-1);
    }
}

// Solution 2 --  还是利用BST的中序遍历是递增序列的性质，可以利用循环迭代方式进行中序遍历，然后维护一个变量，当堆栈pop到第kth个时，即可。
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode crt = root;
    	int number = 0;
    	while( crt != null || !stack.empty() ){
    		while( crt != null ){
    			stack.push(crt);
    			crt = crt.left;
    		}
    		TreeNode tmp = stack.pop();
    		number++;
    		if( number == k ){
    			return tmp.val;
    		}
    		crt = tmp.right;
    	}
    	return -1;
    }
}
