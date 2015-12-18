// Solution 1 --- 典型的递归回溯题目，但是需要注意递归终止条件，这个题目给定n个左括号和n个右括号，任何时刻，都不允许出现
//                剩下的没匹配的右括号数目 < 剩下的没匹配的左括号数目，因为这样就没法mathcing,

// 时间复杂度: O( 2^n ), 非tight upper bound, 注意别想成是O(n!)了，因为每个位置只能放(或者), 只有2个分支，而放具体的哪一个(
//             或者哪一个), 效果一样不会产生差别。所以不是O(n!)
// 空间复杂度: O(n), 递归深度消耗system stack, 匹配完所有括号

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        // corner case
        if( n < 1 ){
            return res;
        }
        dfs( res, n, n, "");
        return res;
    }
    private void dfs(List<String> res, int leftRemaining, int rightRemaining, String temp){
        
        if( rightRemaining < leftRemaining ){
            return;
        }
        if( leftRemaining == 0 && rightRemaining == 0 ){
            res.add(temp);
            return;
        }
        if( leftRemaining > 0 ){
            dfs(res,  leftRemaining - 1, rightRemaining, temp + "(" );
        }
        if( rightRemaining > 0 ){
            dfs(res, leftRemaining, rightRemaining - 1, temp + ")" );
        }
        
    }
}
