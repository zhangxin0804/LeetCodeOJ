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


// Solution 2 --- 如果有环，那么我们利用快慢指针，最终快指针一定能绕一圈后再次追上慢指针，所以通过这个条件来判断。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null ){
            return false;
        }
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast ){
                return true;
            }
        }
        return false;
    }
}

// Solution 1 ---  如果LinkedList有cycle，那么意味着必然会有环，会重复访问节点，因此利用HashMap来找到第一次重复的地方即可。 
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if( head == null ){
        	return false;
        }

        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        ListNode crt = head;
        while( crt != null ){
        	if( hashSet.contains(crt) ){
        		return true;
        	}
        	hashSet.add(crt);
        	crt = crt.next;
        }
        return false;
    }
}

// Solution 3 --- 如果有环，那么我们利用快慢指针，最终快指针一定能绕一圈后再次追上慢指针，所以通过这个条件来判断。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

// 注意：下面这个写法起始时快指针就比慢指针多一个位置，因此之后的相遇，当slow移动一次后，fast有可能只移动一次就可以和slow相遇了。
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if( head == null ){
        	return false;
        }

        ListNode slow = head, fast = head.next;
        while( fast != null && fast.next != null ){
        	if( slow == fast ){
        		return true;
        	}
        	slow = slow.next;
        	fast = fast.next;
        	if( slow == fast ){
        		return true;
        	}
        	fast = fast.next;
        }

        if( slow == fast ){
        	return true;
        }
        return false;
    }
}
