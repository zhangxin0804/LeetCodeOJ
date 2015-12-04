/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Solution 1 -- 根据preorder的结果确定root node, 根据inorder的结果找到root 后，对边界index boundary进行二分得到左右sub tree范围.
// 时间复杂度: O(nlogn), 画图后每一层上实际遍历的节点数始终都是n个，所以一共logn层，所以是O(nlogn)
// 空间复杂度: O(logn), 递归深度即消耗的系统栈

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // assume preorder and inorder are valid
        int length1 = preorder.length;
        int length2 = inorder.length;
        return divideAndConquer(preorder, 0, length1 - 1, inorder, 0, length2 - 1);
    }
    
    private TreeNode divideAndConquer(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        // recursive terminated
        if( preStart > preEnd || inStart > inEnd ){
            return null;
        }
        // recursive body
        int i;
        for(i = inStart; i <= inEnd; i++){
            if( inorder[i] == preorder[preStart] ){
                  break; 
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // 下面的边界index的确定，举实际例子，来计算！
        // preorder: 1 2 4 5 3 6 7
        // inorder:  4 2 5 1 6 3 7
        root.left = divideAndConquer(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        root.right = divideAndConquer(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Solution 2 --- 在Solution 1的基础上，将递归函数中的循环找root的过程，降低至O(1)复杂度，因此可以想用HashMap存储inorder的元素
//                作为key,索引Index作为value
// 时间复杂度: O(n)
// 空间复杂度: O(logn)

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    	// assume 两个给定数组都是valid
    	int length1 = preorder.length; 
    	int length2 = inorder.length;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < length2; i++){
    		map.put(inorder[i],i);
    	}
    	TreeNode root = creatTree(preorder, 0, length1 - 1, inorder, 0, length2 - 1, map);
    	return root;
    }

    private TreeNode creatTree(int[] preorder, int preLeft, int preRight,  int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> map ){

    	if( preLeft > preRight || inLeft > inRight ){
    		return null;
    	}
    	int j = map.get(preorder[preLeft]);

    	// divide and conquer分治递归法，来构建tree
    	TreeNode root = new TreeNode( inorder[j] );
    	root.left = creatTree(preorder, preLeft + 1, preLeft + (j - inLeft), inorder, inLeft, j-1, map);
    	root.right = creatTree(preorder, preLeft + (j - inLeft) + 1, preRight, inorder, j+1, inRight, map);
    	return root;
    }
}
