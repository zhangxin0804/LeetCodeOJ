/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 1 --- 注意如果连续出现待删除元素的时候的处理，
// 时间复杂度: O(n)
// 空间复杂度: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null ){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode crt = dummy;
        while( crt.next != null ){
            if( crt.next.val == val ){
                crt.next = crt.next.next;
                continue;
            }
            crt = crt.next;
        }
        return dummy.next;
    }
}
