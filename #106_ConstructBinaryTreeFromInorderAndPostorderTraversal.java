/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 -- 这回是根据inorder顺序和postorder顺序来重建，方法还是类似的。
// 时间复杂度: O(nlogn)
// 空间复杂度: O(logn)

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
     	int length1 = inorder.length;
     	int length2 = postorder.length;

     	TreeNode root = createTree(inorder, 0, length1-1, postorder, 0, length2-1);
     	return root;
    }

    private TreeNode createTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){

    	if( inLeft > inRight || postLeft > postRight ){
    		return null;
    	}
    	int j = inLeft;
    	while( j <= inRight && inorder[j] != postorder[postRight] ){
    		j++;
    	}
    	TreeNode root = new TreeNode( postorder[postRight] );
    	root.left = createTree(inorder, inLeft, j-1, postorder, postLeft, postLeft + (j - inLeft) - 1 );
    	root.right = createTree(inorder, j+1, inRight, postorder, postLeft + (j - inLeft), postRight - 1 );
    	return root;
    }
}
