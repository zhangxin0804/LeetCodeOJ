/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom 
right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

// Solution 1 -- 注意：元素值为 non-negative, 移动方向只能向下和向右，要求寻找最优解optimal, 可以考虑用DP来解决。
// 时间复杂度: O(m*n)
// 空间复杂度: O(m*n)

/*
状态定义：dp[i][j]表示从起点[0][0]走到[i][j]位置的min path sum
状态转移方程：dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + + grid[i][j]
初始化：二维matrix DP, 根据状态转移方程，需要初始化首行和首列
结果：dp[m-1][n-1]
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        // assume grid is valid
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // initialization
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // recurrent formula
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        // answer
        return dp[m-1][n-1];
    }
}


// Solution 2 ---  在Solution 1的基础上考虑是否能够利用滚动数组，进行空间上的优化。 画图分析滚动数组！！！！
// 时间复杂度: O(m*n)
// 空间复杂度: O(n)

/*
状态定义：dp[i][j]表示从起点[0][0]走到[i][j]位置的min path sum
状态转移方程：dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + + grid[i][j]
初始化：二维matrix DP, 根据状态转移方程，需要初始化首行和首列
结果：dp[m-1][n-1]
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        // assume grid is valid
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        // initialization
        dp[0] = grid[0][0];
        for(int j = 1; j < n; j++){
        	dp[j] = dp[j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
        	dp[0] = grid[i][0] + dp[0];
        	for(int j = 1; j < n; j++){
        		dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
        	}
        }
        return dp[n-1];
    }
}
