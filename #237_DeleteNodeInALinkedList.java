// Solution 1 -- 一般删除节点都是给定要删除节点之前的node, 这里只给定了要删除节点，这可以直接进行值拷贝，然后调整后序指针。
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
