/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Solution 1 --- 双指针，前后指针预先设定好位置，再同时移动。注意头结点可能变化，因此要考虑用dummy node
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode front = dummyNode;
        ListNode back = dummyNode;
        while( n-- > 0 ){
        	front = front.next;
        }

        while( front.next != null ){
        	front = front.next;
        	back = back.next;
        }

        back.next = back.next.next;
        return dummyNode.next;
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

// Solution 2  ---- 利用递归时消耗的系统堆栈结构，具有LIFO的性质来得到从后往前的第XX个Node, 注意头结点可能变化，要考虑用dummy node.
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummyNode = new ListNode(0);
    	dummyNode.next = head;
    	recursive(dummyNode, n);
    	return dummyNode.next;
    }

    private int recursive(ListNode head, int n){
    	if( head == null ){
    		return 0;
    	}
    	int res = recursive(head.next, n);
    	if( res == n ){
    		head.next = head.next.next;
    	}
    	return res + 1;
    }
}
