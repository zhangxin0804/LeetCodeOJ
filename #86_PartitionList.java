// Solution 1 --- 可以考虑维护两个partial linked list分别各自添加less than x nodes和greate or equal to x nodes,
//                最后再拼到一起，因为最终的head node可能会变化，可以考虑引入dummyNode.
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public ListNode partition(ListNode head, int x) {
        // empty list or singe node lists
        if( head == null || head.next == null ){
        	return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode left = dummy1, right = dummy2;
        while( head != null ){
        	if( head.val < x ){
        		left.next = head;
        		left = left.next;
        	}else{
        		right.next = head;
        		right = right.next;
        	}
        	head = head.next;
        }
        // 注意: 记得将right.next置为null, 避免环
        right.next = null;
        left.next = dummy2.next;
        return dummy1.next;
    }
}
