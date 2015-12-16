

// Solution 1 --- 找中点，翻转reverse linked list, 合并两个list, 注意奇数偶数的不同情况。
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
    public void reorderList(ListNode head) {
        if( head == null || head.next == null ){
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode rev = reverse(middle.next);
        middle.next = null; // 截断处理！！
        ListNode dummy = new ListNode(0);
        ListNode crt = dummy;
        while( head != null && rev != null ){
            crt.next = head;
            head = head.next;
            crt = crt.next;

            crt.next = rev;
            rev = rev.next;
            crt = crt.next;
        }
        if( head != null ){
            crt.next = head;
        }
        head = dummy.next; 
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while( head != null ){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
