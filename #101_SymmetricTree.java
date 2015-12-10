/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 -- 可以考虑对左子树采用根左右的递归方式，对右子树采用根右左的递归方式，进行2路DFS，来保证structure和value都相同。
//               递归recursive解法。
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度。

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if( root == null ){
        	return true;
        }
        return twoWayDFS(root.left, root.right);
    }

    private boolean twoWayDFS(TreeNode root1, TreeNode root2){

    	// recursive terminated
    	if( root1 == null && root2 != null || root1 != null && root2 == null ){
    		return false;
    	}
    	if( root1 == null && root2 == null ){
    		return true;
    	}
    	if( root1.val != root2.val ){
    		return false;
    	}
    	// recursive body
    	return twoWayDFS(root1.left, root2.right) && twoWayDFS(root1.right, root2.left);
    }
}

// Solution 2 --- 思路仍然是一样的，但是现在考虑迭代的解法入手。相当于我们利用两个stack, 从两个子树root node开始
//                进行迭代的pre-order traversal. 注意每次左子树push后，和右子树push后，用size做检测。如果sizeBuyiyang ,
//                则直接return false; 
// 时间复杂度: O(n)
// 空间复杂度: O(h)

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if( root == null ){
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        if( root.left != null ){
            stack1.push(root.left);
        }
        if( root.right != null ){
            stack2.push(root.right);
        }
        while( !stack1.empty() && !stack2.empty() ){
            TreeNode crt1 = stack1.pop();
            TreeNode crt2 = stack2.pop();
            if( crt1.val != crt2.val ){
                return false;
            }
            if( crt1.right != null ){
                stack1.push(crt1.right);
            }
            if( crt2.left != null ){
                stack2.push(crt2.left);
            }
            if( stack1.size() != stack2.size() ){
                return false;
            }
            if( crt1.left != null ){
                stack1.push(crt1.left);
            }
            if( crt2.right != null ){
                stack2.push(crt2.right);
            }
            if( stack1.size() != stack2.size() ){
                return false;
            }
        }
        
        if( stack1.empty() && stack2.empty() ){
            return true;
        }
        return false;
    }
}

