/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 -- 迭代做法iterative.
//               注意：in-place完成flatten操作，仔细观察flatten后的结果是类似preorder traversal, 因此我们用先序遍历的迭代来
//               处理，同时类似Linked List的操作，这题的关键！！！是我们要学会，维护一个prev指针！！然后通过prev指针和crt指针来
//               重新调整指针指向！！

// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度。

public class Solution {
    public void flatten(TreeNode root) {
        if( root == null ){
            return;
        }
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while( !stack.empty() ){
            TreeNode crt = stack.pop();
            if( crt.right != null ){
                stack.push(crt.right);
            }
            if(crt.left != null ){
                stack.push(crt.left);
            }
            if( prev != null ){
                prev.left = null;
                prev.right = crt;
            }
            prev = crt;
        }
    }
}


// Solution 2 --- recursive递归解法,采用分治递归的思路。还是要从一个宏观的角度入手。即分治递归函数帮我们把left sub tree已经
//                flatten完，也帮我们把right sub tree已经flatten, 现在要将当前的tree再flatten好，首先要把left flatten sub tree
//                拼到右侧来，然后左侧set null, 然后呢，要把之前的right flatten sub tree拼接到left flatten sub tree的最右下处
//                因此需要一个while循环，从此时root继续不断往下找，直到某个node.right == null是，即找到该最右下node, 然后将right
//                flatten sub tree拼上，最后返回root.

// 时间复杂度: O(n)
// 空间复杂度: O(h),h为树的高度

public class Solution {

    public void flatten(TreeNode root) {
        // 如果是empty tree, 直接return
        if( root == null ){
            return;
        }
        divideAndConquer(root);
    }

    private TreeNode divideAndConquer(TreeNode root){

        if( root == null ){
            return null;
        }

        TreeNode flatteLeft = divideAndConquer(root.left);
        TreeNode flattenRight = divideAndConquer(root.right);
        root.right = flatteLeft;
        root.left = null;
        TreeNode crt = root;
        while( crt.right != null ){
            crt = crt.right;
        }
        crt.right = flattenRight;
        return root;
    }
}
