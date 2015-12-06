// Solution 1 -- 类似DP的思想解法
/*
1. 用一个boolean二维数组来保存index i到index j也即boolea[i][j]是否是回文的标记。
2. 先分别标记好单个字符，和两个字符的情况。
3. 然后在考虑3个，4个，。。。。。到之后的情况。判断的时候实际上就是每次增加一个新的字符，首先根据头尾之间的boolan数组来判断内部是否回文。
在判断头尾是否也是相等，如果是的话，整体就是回文。
4. 
*/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n^2)

public class Solution {
    public String longestPalindrome(String s) {
        // 空字符串以及单个字符的字符串，都可以认为是回文字符串
        if( s == null || s.length() == 0 || s.length() == 1 ){
        	return s;
        }
        boolean[][] markArr = null;
        int length = s.length();
        markArr = findLongestPalindromeDP(s);
        int maxLength = Integer.MIN_VALUE;
        int start = 0, end = 0;

        for(int i = 0; i < length; i++){
        	for(int j = i; j < length; j++){
        		if( markArr[i][j] == true ){
        			if( j - i + 1 > maxLength ){
        				maxLength = j - i + 1;
        				start = i;
        				end = j;
        			}
        		}
        	}	
        }
        return s.substring(start,end+1);
    }

    private boolean[][] findLongestPalindromeDP(String s){

    	int length = s.length();
    	boolean[][] markArr = new boolean[length][length];
    	// 单个字符组成的字符串必为回文
    	for(int i = 0; i < length; i++){
    		markArr[i][i] = true;
    	}
    	// 两个字符组成的字符串，要前后字符判断一下。
    	for(int i = 0; i < length - 1; i++){
    		if( s.charAt(i) == s.charAt(i+1) ){
    			markArr[i][i+1] = true;
    		}
    	}

    	for(int j = 2; j < length; j++){ // 外层循环是间隔字符数
    		for(int i = 0; (i + j) < length; i++ ){ // 内层循环是每个substring的起点位置
    			if( markArr[i+1][i+j-1] == true && (s.charAt(i) == s.charAt(i+j)) ){
    				markArr[i][i+j] = true;
    			}
    		}
    	}
    	return markArr;
    }
}

// Solution2 --- 循环迭代，从回文字符串的特点即存在中心对称入手，情况1：中心对称为一个字符；情况2：中心对称为两个字符。
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)

public class Solution {
    public String longestPalindrome(String s) {
        // 空字符串以及单个字符的字符串，都可以认为是回文字符串
        if( s == null || s.length() == 0 || s.length() == 1 ){
        	return s;
        }

        int length = s.length();
        int maxLength = 1; // default is one character
        int left = 0, right = 0;
        for(int k = 0; k < length; k++){

            int i = k - 1, j = k + 1;
            while( (i >= 0) && (j < length) && (s.charAt(i) == s.charAt(j)) ){
                i--;
                j++;
            }
            int tmp1 = i + 1, tmp2 = j - 1;
            if( tmp2 - tmp1 + 1 > maxLength ){
                maxLength = Math.max(maxLength, tmp2 - tmp1 + 1);
                left = tmp1;
                right = tmp2;
            }

            if( k + 1 == length ){
                break;
            }
            if( s.charAt(k) != s.charAt(k+1) ){
                continue;
            }

            i = k - 1;
            j = k + 1 + 1;
            while( (i >= 0) && (j < length) && (s.charAt(i) == s.charAt(j)) ){
                i--;
                j++;
            }
            tmp1 = i + 1;
            tmp2 = j - 1;
            if( tmp2 - tmp1 + 1 > maxLength ){
                maxLength = Math.max(maxLength, tmp2 - tmp1 + 1);
                left = tmp1;
                right = tmp2;
            }
        }
        return s.substring(left, right+1);
    }
}
