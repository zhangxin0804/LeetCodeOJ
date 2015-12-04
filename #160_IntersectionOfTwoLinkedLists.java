/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Solution 1 -- 注意题目中找的是相交的那个点, 即这个点之后两个链表共用部分。先找到长的那个，然后确定长的和短的差的个数，然后长的先移动这么多。
//               然后再同时一起移动，看是否会相遇。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        int numA = 0, numB = 0;
        ListNode copyA = headA, copyB = headB;
        while( copyA != null || copyB != null ){
            if( copyA != null ){
               numA++;
               copyA = copyA.next;
            }
            if( copyB != null ){
                numB++;
                copyB = copyB.next;
            }
        }
        if( numA > numB ){
            int count = numA - numB;
            while( count-- > 0 ){
                headA = headA.next;
            }
        }else{
            int count = numB - numA;
            while( count-- > 0 ){
                headB = headB.next;
            }
        }
        while( headA != headB ){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;  
    }
}

// Solution 2 -- 利用HashSet存储其中一个List的所有nodes, 然后遍历另外一个list找到第一个duplicate的node返回
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
        while( headA != null ){
            set.add(headA);
            headA = headA.next;
        }
        while( headB != null ){
            if( set.contains(headB) ){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
