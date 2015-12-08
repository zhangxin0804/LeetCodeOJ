/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // Solution 1  --- 遍历linked list按照digit求和，注意进位位的维护，注意循环结束后的进位位判断，注意三目运算符使用和循环条件。
 // 时间复杂度: O(n)
 // 空间复杂度: O(1), 不算解集空间

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if( l1 == null || l2 == null ){
            return l1 == null ? l2 : l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode crt = dummyNode;
        int carry = 0;
        while( l1 != null || l2 != null ){
            int val1 = (l1 == null)?0:l1.val;
            int val2 = (l2 == null)?0:l2.val; 
            ListNode node = new ListNode( (val1+val2+carry) % 10 );
            if( val1 + val2 + carry >= 10 ){
                carry = 1;
            }else{
                carry = 0;
            }
            l1 = ( l1 != null )?l1.next:null;
            l2 = ( l2 != null )?l2.next:null;
            crt.next = node;
            crt = crt.next;
        }
        if( carry == 1 ){
            ListNode node = new ListNode(1);
            crt.next = node;
            crt = crt.next;
        }
        return dummyNode.next;
    }
}

// Solution 2 --- 下面这种解法虽然空间复杂度为O(1), 但是改变了输入参数，其实是不推荐这么做的
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if( l1 == null || l2 == null ){
            return l1 == null ? l2 : l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode crt = dummyNode;
        int carry = 0;
        while( l1 != null || l2 != null ){
            int val1 = ( l1 == null )?0:l1.val;
            int val2 = ( l2 == null )?0:l2.val;
            ListNode tmp  = ( l1 == null )?l2:l1; // 先把结果存在l1上，l1没有空间了，再存l2上
            tmp.val = (val1 + val2 + carry) % 10;
            crt.next = tmp;
            if( val1 + val2 + carry >= 10 ){
                carry = 1;
            }else{
                carry = 0;
            }
            l1 = ( l1 == null )?null:l1.next;
            l2 = ( l2 == null )?null:l2.next;
            
            crt = crt.next;
        }
        
        if( carry == 1 ){
            ListNode newNode = new ListNode(1);
            crt.next = newNode;
        }
        return dummyNode.next;
    }
}
