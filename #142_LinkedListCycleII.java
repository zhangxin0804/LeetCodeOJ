/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Solution 1  ---- 先确定是否有环，然后相遇后slow指针继续前进，新的指针从头前进，他们相遇时即为cycle的start点。
//                  画图，推到公式！！
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null ){
            return null;
        }
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            // 如果有环，再继续一个从head, 一个从当前位置，同时同速前进。
            if( slow == fast ){
                slow = head;
                while( fast != slow ){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
