// Solution 1 --- 注意另一道LCA的题目不是BST而是一般的BT， 借助BST的性质
// 时间复杂度: worst case ~ O(n)比如BST不是balanced, 而average case ~~ O(logn)
// 空间复杂度: O(1)

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // assume p and q are both in tree and not equal to null
        if( root == p || root == q ){
            return root;
        }
        if( (root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val) ){
            return root;
        }else if( root.val > p.val && root.val > q.val ){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
