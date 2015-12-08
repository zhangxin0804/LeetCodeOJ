// Solution 1 --- 首先有个标记变量来作为当前方向的指示,根据不同的方向指示，我们来决定是否reverse这一层的order
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
          return res;
        }
        boolean direction = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
           int size = queue.size();
           List<Integer> each = new ArrayList<Integer>();
           for(int i = 0; i < size; i++) {
             
             TreeNode temp = queue.poll();
             each.add(temp.val);
             
             if(temp.left != null) {
               queue.offer(temp.left);
             }
             
             if(temp.right != null) {
               queue.offer(temp.right);
             }

           }
           if(direction) {
             res.add(each);
             direction = false;
           }
           else {
             // 注意这里，利用Collections的API来帮助隔层reverse.
             Collections.reverse(each);
             res.add(each);
             direction = true;
           }
        }
        return res;
    }
}
