// Solution 1 -- 这种后一个结果，依赖前一个结果的问题，利用prev和crt的来回交替更新来做，最直观。
// 时间复杂度: O(n*k)
// 空间复杂度: O(k)

public class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = new StringBuilder();
        prev.append(1);
        if( n == 1 ){
            return prev.toString();
        }
        n = n - 1;
        while( n-- > 0 ){
            StringBuilder crt = new StringBuilder();
            char tmpChar = prev.charAt(0);
            int tmpCnt = 1;
            for(int i = 1; i < prev.length(); i++){
                if( prev.charAt(i) == tmpChar ){
                   tmpCnt++; 
                }else{
                    // 注意：这里的顺序是先空字符串，再append后面的
                    crt.append(""+tmpCnt+tmpChar);
                    tmpCnt = 1;
                    tmpChar = prev.charAt(i);
                }
            }
            // 别忘了外面循环结束，还要append一次。
            crt.append(""+tmpCnt+tmpChar);
            prev = crt;
        }
        return prev.toString();
    }
}
