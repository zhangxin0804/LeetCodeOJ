// Solution 1 ---- 典型的dp问题，求解最优解。
/*
状态定义: dp[i]表示从index = 0走到index = i的房子，最多能偷多少钱。
状态转移方程: dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
*/
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public int rob(int[] nums) {
        if( nums == null || nums.length == 0 ){
        	return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        if( length == 1 ){
        	dp[0] = nums[0];
        }else if( length == 2 ){
        	dp[0] = nums[0];
        	dp[1] = Math.max(dp[0], nums[1]);
        }else{
        	dp[0] = nums[0];
        	dp[1] = Math.max(dp[0], nums[1]);        	
        	for(int i = 2; i < length; i++){
        		dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        	}
        }
        return dp[length-1];
    }
}
