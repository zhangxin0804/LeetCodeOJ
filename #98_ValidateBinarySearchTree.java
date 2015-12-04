/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/


// Solution 1 ---- 分治递归方法, 注意到由于要保证当前root的值比其左侧subTree中的值都要大，比其右侧subTree中的值都要小。我们在top-down
//                 递归时，可以将root val传递下去用于更新min bound value,和max bound value
//                 注意：因为root.val可能会出现Integer.MAX_VALUE或者Integer.MIN_VALUE, 因此初始的boundary要比他们范围更大才行！
//                 使用Double.POSITIVE_INFINITY和Double.NEGATIVE_INFINITY
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

    public boolean isValidBST(TreeNode root) {        
    	if( root == null ){
    		return true;
    	}
    	return checkValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);	
    }

    private boolean checkValid(TreeNode root, double lowBound, double highBound){
        // recursive terminated
    	if( root == null ){
    		return true;
    	}
        // 注意这里小于等于lowBound或者大于等于upperBound就是invalid的了！注意等于的情况！
    	if( root.val <= lowBound || root.val >= highBound ){
    		return false;
    	}
    	return checkValid( root.left, lowBound, root.val) && checkValid( root.right, root.val, highBound) ;
    }
}

// Solution 2 --- 先迭代方式中序遍历该BST，维护Prev指针，直接在iterative中序遍历过程中判断。
// 时间复杂度: O(n)
// 空间复杂度: O(h), h 为树的高度

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
    public boolean isValidBST(TreeNode root) {
        
        // 空树算valid BST
        if( root == null ){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode crt = root;
        TreeNode prev = null;

        while( crt != null || !stack.empty() ){
            while( crt != null ){
                stack.push(crt);
                crt = crt.left;
            }
            TreeNode tmp = stack.pop();
            if( prev != null ){
                if( prev.val >= tmp.val ){
                    return false;
                }
            }
            prev = tmp;
            crt = tmp.right;
        }
        return true;
    }
}

// Solution 3 --- 先迭代方式中序遍历该BST，然后结果存入一个arrayList, 在判断是否为增序序列。
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
    public boolean isValidBST(TreeNode root) {
        
        // 空树算valid BST
        if( root == null ){
            return true;
        }
        ArrayList<Integer> inorderRes = new ArrayList<Integer>();
        inorderTraversal(root, inorderRes);
        if( inorderRes.size() == 1 ){
            return true;
        }
        for(int i = 1; i < inorderRes.size(); i++){
            if( inorderRes.get(i) <=  inorderRes.get(i-1) ){
                return false;
            }
        }
        return true;
    }
    private void inorderTraversal(TreeNode root, ArrayList<Integer> inorderRes){

        TreeNode crt = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while( crt != null || !stack.empty() ){
            while( crt != null ){
                stack.push(crt);
                crt = crt.next;
            }
            TreeNode tmp = stack.pop();
            inorderRes.add(tmp.val);
            crt = tmp.right;
        }
    }
}
