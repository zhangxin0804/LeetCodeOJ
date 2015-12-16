// Solution 1 -- 既然是integer就有可能为负数, 负数不能是palindrome, 不能用extra space, 我们考虑reverse integer, 如果是回文数字，
//               reverse后值，应该一样。注意reverse的时候可能会overflow, 我们用更大的数据类型来存储。

// 时间复杂度: O(n), n是这个数的digits的数目
// 空间复杂度: O(1)

public class Solution {
    public boolean isPalindrome(int x) {
        // corner case: negative number
        if( x < 0 ){
            return false;
        }
        // corner case: zero
        if( x == 0 ){
            return true;
        }
        long rev = reverseDigits(x);
        if( rev > Integer.MAX_VALUE ){
            return false;
        }
        if( (int)rev != x ){
            return false;
        }
        return true;
    }
    private long reverseDigits(int x){
        long res = 0L;
        while( x != 0 ){
            res = res * 10 + x%10;
            x = x/10;
        }
        return res;
    }
}
