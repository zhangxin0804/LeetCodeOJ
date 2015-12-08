// Solution 1 ---- Iterative方式
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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null ){
        	return head;
        }
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




// Solution 2 ---- Recursive方法
// 时间复杂度: O(n)
// 空间复杂度: O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
       	if( head == null || head.next == null ){
       		return head;
       	} 
       	return divideAndConquer(head);
    }

    private ListNode divideAndConquer(ListNode head){

    	if( head.next == null ){  // 注意这个递归终止条件
    		return head;
    	}
    	ListNode revNode = divideAndConquer(head.next);

    	head.next.next = head;
    	head.next = null;
    	return revNode;      // 注意返回值始终返回reverse之后的新的head
    }
}
