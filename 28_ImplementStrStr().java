
// Solution 1 --- brute force解法，双重循环，注意变量的控制。
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)

public class Solution {
    public int strStr(String haystack, String needle) {
        if( (haystack == null || haystack.length() == 0) && (needle != null && needle.length() != 0) ){
            return -1;
        }
        if( (haystack != null && haystack.length() != 0) && (needle == null || needle.length() == 0) ){
            return 0;
        }
        if( (haystack == null || haystack.length() == 0) && (needle == null || needle.length() == 0) ){
            return 0;
        }
        
        int length1 = haystack.length();
        int length2 = needle.length();
        int i = 0, j = 0;
        // 注意最外层for循环的优化即i的范围。
        for(i = 0; i < length1 - length2 + 1; i++){
            for(j = 0; j < length2; j++){
                if( haystack.charAt(i+j) != needle.charAt(j) ){
                    break;
                }
            }
            if( j == length2 ){
                return i;
            }
        }
        return -1;
    }
}
