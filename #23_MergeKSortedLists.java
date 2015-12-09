/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 1 --- 利用堆heap即优先队列priority queue来解决, 注意最初的lists中也可能有空的情况，即lists[i] == null, 多个if判断
// 时间复杂度: O( m * k * logk ), k为Lists个数，m为每个list的平均Nodes个数。
// 空间复杂度: O(k), k为heap size

class NodeComp implements Comparator<ListNode>{

	public int compare(ListNode node1, ListNode node2){
		int val1 = node1.val;
		int val2 = node2.val;
		if( val1 > val2 ){
			return 1;
		}else if( val1 < val2 ){
			return -1;
		}
		return 0;
	}
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if( lists == null || lists.length == 0 ){
        	return null;
        }
        NodeComp comparator = new NodeComp();
        int length = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(length,comparator);

        ListNode dummyNode = new ListNode(0);
        ListNode crt = dummyNode;
        // heap中不允许有null element
        for(int i = 0; i < length; i++){
        	if( lists[i] != null ){
        		minHeap.offer(lists[i]);
        	}
        }
        while( !minHeap.isEmpty() ){
        	ListNode tmp = minHeap.poll();
        	crt.next = tmp;
        	crt = crt.next;
        	if( tmp.next != null ){
        		minHeap.offer(tmp.next);
        	}
        }
        return dummyNode.next;
    }
}

// Solution 2 ---- 通过divide and conquer分治递归算法，来将问题不断分解后，最终变成merge 2 sorted lists, 再comgbine得到结果。
// 时间复杂度: O( m * k * logk ), 分析类似merge sort注意每一层实际的操作时间复杂度为O(m*k), 一共有logk层。
// 空间复杂度: O(logk), 递归深度，消耗的system stack

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0 ){
            return null;
        }
        int length = lists.length;
        return mergeSortedLists(lists, 0, length-1);
    }

    private ListNode mergeSortedLists(ListNode[] lists, int start, int end){
        if( start == end ){
            return lists[start];
        }
        int middle = start + ((end-start) >> 1);
        ListNode l1 = mergeSortedLists(lists, start, middle);
        ListNode l2 = mergeSortedLists(lists, middle+1, end);
        return mergeTwoSortedLists(l1, l2);      
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        if( l1 == null || l2 == null ){
            return ( l1 == null ) ? l2 : l1;
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
