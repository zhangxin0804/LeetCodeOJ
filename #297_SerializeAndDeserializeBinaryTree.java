// Solution 1 -- 利用BFS + Queue + null的标记#, 来serialize, 再利用Queue来重新构建deserialize
// 时间复杂度: O(n)
// 空间复杂度: O(n)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if( root == null ){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        sb.append(root.val);
        sb.append(",");
        while( !queue.isEmpty() ){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode crt = queue.poll();
                if( crt.left != null ){
                    queue.offer(crt.left);
                    sb.append(crt.left.val);
                }else{
                    sb.append("#");
                }
                sb.append(",");
                if( crt.right != null ){
                    queue.offer(crt.right);
                    sb.append(crt.right.val);
                }else{
                    sb.append("#");
                }
                sb.append(",");
            }
        }
        // 删除多出来的一个,
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if( data == null ){
            return null;
        }
        String[] str = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(str[index++]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() && index < str.length ){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode crt = queue.poll();
                if( !str[index].equals("#") ){
                   TreeNode left = new TreeNode(Integer.parseInt(str[index++])); 
                   crt.left = left;
                   queue.offer(left);
                }else{
                    index++;
                }
                if( !str[index].equals("#") ){
                    TreeNode right = new TreeNode(Integer.parseInt(str[index++])); 
                    crt.right = right;
                    queue.offer(right);
                }else{
                    index++;
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
