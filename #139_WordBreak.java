// Solution 1 --- Yes/No 是否存在某个solution类型的DP问题， “When you see string problem that is about subsequence or matching
//                or partitioning, dynamic programming method should come to your mind naturally. ” 很重要的一个技巧和意识！

// 状态定义: dp[i]表示前i个字符组成的字符串，是否能够被segment into one or more dictionary words
// 状态转移方程: dp[i] = {dp[j] == true && [第j+1个字符, 第i个字符] in dict } ? true : false;

/*
1. 因为我们的状态描述是前i个字符的描述，因此意味着我们在状态描述上和实际字符的index上是有off-one差别的，注意！
2. 最初的dp数组，在声明空间的时候要多声明一个单位，以符合状态的描述。
3. 大状态是dp[i]即前i个字符组成的字符串是否能够被切分成字典中的words, 我们要分析能够推导到大状态的最近的小状态是什么.
因此，可以枚举前面的某个位置j, 当dp[j] = true 且 [第j+1个字符, 第i个字符]组成的子串也在dict中，即可。否则就为false
*/

// 时间复杂度: O( n^2 )
// 空间复杂度: O(n)

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // assume s is not null or empty and wordDict is not null or empty
        int length = s.length();
        boolean[] dp = new boolean[length+1]; // default is false
        
        // initialization
        dp[0] = true;
        
        // dp recurrent formula, 注意i从1开始，表示前i个字符组成的子串的情况
        for(int i = 1; i < length + 1; i++){
            // 注意j的起始位置, 考虑第一个字符的情况就可以分析出来
            for(int j = 0; j < i; j++){
                if( dp[j] && wordDict.contains(s.substring(j, i)) ){
                    dp[i] = true;
                    break;
                }
            }
        }
        // result
        return dp[length];
    }
}
