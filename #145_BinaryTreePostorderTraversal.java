// Solution 1 --- 递归解法
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
        	return result;
        }

        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root){
    	if( root == null ){
    		return;
    	}
    	dfs(result, root.left);
    	dfs(result, root.right);
    	result.add(root.val);
    }

}



// Solution 2 --- 非递归解法，迭代解法
// 时间复杂度:  O(n)
// 空间复杂度: O(h)

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
        	return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        stack.push(root);

        while( !stack.empty() ){
        	TreeNode crt = stack.peek();
        	if( prev == null || prev.left == crt || prev.right == crt ){
        		if( crt.left != null ){
        			stack.push(crt.left);
        		}else if( crt.right != null ){
        			stack.push(crt.right);
        		}else{
        			// 左边all the way down到达leaf node
        			TreeNode leaf = stack.pop();
        			result.add(leaf.val);
        		}
        	}else if( crt.left == prev ){
        		if( crt.right != null ){
        			stack.push( crt.right );
        		}else{
        			TreeNode tmp = stack.pop();
        			result.add(tmp.val);        			
        		}
        	}else if( crt.right == prev ){
        		TreeNode tmp = stack.pop();
        		result.add(tmp.val);
        	}
        	prev = crt;
        }
        return result;
    }
}

// Solution 3 -- 先序遍历的口诀是 根左右, 后序遍历的口诀是左右根，可以考虑先序遍历时调整顺序为根右左，最后结果再reverse一下。
//               tricky的叼逼方法！！！！
// 时间复杂度: O(n)
// 空间复杂度: O(h)

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if( root == null ){
            return res;
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while( !stack.empty() ){
            TreeNode crt = stack.pop();
            res.add(crt.val);
            if( crt.left != null ){
                stack.push(crt.left);
            }
            if( crt.right != null ){
                stack.push(crt.right);
            }
        }
        reverse(res);
        return res;
    }
    
    private void reverse(List<Integer> res){
        int i = 0, j = res.size()-1;
        while( i <= j ){
            int temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
    }
}
