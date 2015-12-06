// Solution 1 --- 注意dummy node的使用，while循环控制条件。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     
     	if( l1 == null || l2 == null ){
     		return (l1==null)?l2:l1;
     	}   

     	ListNode dummyNode = new ListNode(0);
     	ListNode crt = dummyNode;

     	while( l1 != null && l2 != null ){
     		if( l1.val <= l2.val ){
     			crt.next = l1;
     			l1 = l1.next;
     		}else{
     			crt.next = l2;
     			l2 = l2.next;
     		}
     		crt = crt.next;
     	}

     	if( l1 != null ){
     		crt.next = l1;
     	}
     	if( l2 != null ){
     		crt.next = l2;
     	}

     	return dummyNode.next;
    }
}
