
/*
注意题目中height balanced binary tree的定义，the depth of the 
two subtrees of every node never differ by more than 1
也就是说，对于每一个节点every node, 我们都要保证depth of the two subtree of 这个节点 never differ by more than 1
只有这样，才能是一种递归的定义，即每一个节点的左右子树的深度差都不能超过1，这样才能保证局部balanced和全局balanced.
*/

// Solution 2 --- Solution 1是双重递归，其中getHeight函数会不断地被调用多次。之前我们说过，双重递归合并成单递归，
//                可以考虑将两个返回值不同类型的函数，统一起来，用同一个类型返回值的函数来表达多重意思。因为，我们既要
//                保证子树都为balanced，也要计算得到子树的depth再来确定当前树是否为balanced, 因此计算height是个
//                必不可少的问题，我们试想，能否通过一个int值来传递子树是否为balanced的信息呢？是可以的，利用-1值
//                表示子树不是balanced即可！！

// 时间复杂度: O(n)
// 空间复杂度: O(h)

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if( root == null ){
        	return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if( left == -1 || right == -1 || Math.abs(left-right) > 1 ){
    		return false;
    	}
    	return true;
    }


    private int getHeight(TreeNode root){
    	if( root == null ){
    		return 0;
    	}
    	int left = getHeight(root.left);
    	int right = getHeight(root.right);

    	if( left == -1 || right == -1 || Math.abs(left-right) > 1 ){
    		return -1;
    	}
    	return Math.max(left, right) + 1;
    }
}



// Solution 1 --- 双重递归方法，因为getHeight是一个递归函数，isBalanced也是一个递归函数，递归中嵌套递归。
// 时间复杂度: O(n^2)
// 空间复杂度: O(h)
/*
public class Solution {
    public boolean isBalanced(TreeNode root) {    
        if( root == null ){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        // 一方面对于当前node的子树高度差要满足要求
        if( Math.abs(left-right) > 1 ){
            return false;
        }  
        // 另一方面，其递归下去的子树中的nodes也要再次满足递归定义。
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root){
        if( root == null ){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
*/
