// Solution 1 --- 注意先要trim掉leading和trailing spaces. 单词之间可能有多个space, 我们希望reduce到一个space.
//                解法实际上涉及维护了一个sliding window, 注意当window right碰到空格字符时，我们如何处理？先继续
//                前进window right, 直到再次碰到非空格字符时，再收缩window left, 期间注意一些控制变量。
// 时间复杂度: O(n)
// 空间复杂度: O(1), 不算解集空间。

public class Solution {
    public String reverseWords(String s) {
        if( s == null || s.length() == 0 ){
            return s;
        }  
        s = s.trim();
        if( s.length() == 0 ){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int left = 0, right = 0;
        for(right = 0; right < length; right++){
            if( s.charAt(right) == ' ' ){
                sb.insert(0, s.substring(left, right));
                sb.insert(0," ");
                while( right < length && s.charAt(right) == ' ' ){
                    right++;
                }
                if( right != length ){
                    left = right;  
                }
            }
        }
        sb.insert(0, s.substring(left, right));
        sb.insert(0," ");        
        return sb.substring(1, sb.length());
    }
}

