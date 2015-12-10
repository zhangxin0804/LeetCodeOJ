// Solution 1 --- 检测两个binary tree是否完全same, 要求结构一样，值也一样。分治递归来做。
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为树的高度，递归深度。

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
    	// recursive terminated
    	if( p == null && q != null || p != null && q == null ){
    		return false;
    	}
    	if( p == null && q == null ){
    		return true;
    	}
    	if( p.val != q.val ){
    		return false;
    	}
    	// recursive body
    	boolean isLeftSubSame = isSameTree(p.left, q.left);
    	boolean isRightSubSame = isSameTree(p.right, q.right);

    	if( isLeftSubSame && isRightSubSame ){
    		return true;
    	}

    	return false;
    }
}
