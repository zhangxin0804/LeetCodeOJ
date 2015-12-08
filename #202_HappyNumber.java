// Solution 1 -- 用HashMap记录之前出现过的中间结果，用于判断是否会repeat
// 时间复杂度: O(logn)
// 空间复杂度: O(1)

public class Solution {
    public boolean isHappy(int n) {
        if( n <= 0 ){
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while( n != 1 ){
            n = getSumSquareDigit(n);
            if( set.contains(n) ){
                return false;
            }
            set.add(n);
        }
        return true;
    }
    private int getSumSquareDigit(int n){
        int sum = 0;
        while( n != 0 ){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
