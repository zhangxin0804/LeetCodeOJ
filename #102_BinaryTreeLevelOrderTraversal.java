
// Solution 1 -- BFS
// 时间复杂度: O(n)
// 空间复杂度: O(2^(h-1)), h为树的高度

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if( tmp.left != null ){
                    queue.offer(tmp.left);
                }
                if( tmp.right != null ){
                    queue.offer(tmp.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}


// Solution 2 -- DFS, 既然要求递归实现层序遍历，那么必然要在递归的时候, 记录一下当前所在的层，也即把当前层和递归遍历的node联系在一起
//               这样最后才能按照层序输出
// 时间复杂度: O(n)
// 空间复杂度: O(h), h为递归深度

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( root == null ){
            return res;
        }
        dfs(root, res, 1);
        return res;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> res, int height){
        if( root == null ){
            return;
        }    
        if( height > res.size() ){
            List<Integer> each = new ArrayList<Integer>();
            each.add(root.val);
            res.add(each);
        }else{
            List<Integer> tmp = res.get(height-1);
            tmp.add(root.val);
        }
        dfs(root.left, res, height + 1);
        dfs(root.right, res, height + 1);
    }
}


