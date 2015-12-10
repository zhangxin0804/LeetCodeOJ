
// Solution 1 -- 先用trim把leading space和trailing space都trim掉。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int lengthOfLastWord(String s) {
        if( s == null || s.length() == 0 ){
            return 0;
        }
        s = s.trim();
        if( s.length() == 0 ){
            return 0;
        }
        int i = s.length() - 1;
        while( i >= 0 && s.charAt(i) != ' ' ){
            i--;
        }
        return s.length() -1 - i;
    }
}
