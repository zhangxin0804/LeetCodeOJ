/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

// Solution 1 -- 找中点，reverse, 同时遍历检测对称性。
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
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null ){
            return true;
        }
        // find mid, cut and reverse
        ListNode middle = findMiddle(head);
        ListNode revHead = reverse(middle.next);
        middle.next = null;
        while( head != null && revHead != null ){
            if( head.val != revHead.val ){
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 2 -- O(n)时间遍历LinkedList, O(n)空间存遍历结果，然后check palindrome.
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null ){
            return true;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while( head != null ){
            res.add(head.val);
            head = head.next;
        }
        int left = 0, right = res.size()-1;
        while( left <= right ){
            // 注意！对象之间的比较！.equals()
            if( res.get(left).equals(res.get(right)) ){
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}
