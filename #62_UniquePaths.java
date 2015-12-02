/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/


// Solution 1 -- 典型的二维matrix DP问题, 定义好状态和转义方程，注意二维matrix DP问题的初始化
// 时间复杂度: O( m * n )
// 空间复杂度: O( m * n )

/*
状态定义：
dp[i][j]表示从初始位置走到(i,j)位置的unique paths数量

状态转义方程：
dp[i][j] = dp[i-1][j] + dp[i][j-1]
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        // 初始化第一行
        for(int j = 1; j < n; j++){
        	dp[0][j] = dp[0][j-1];
        }
        // 初始化第一列
        for(int i = 1; i < m; i++){
        	dp[i][0] = dp[i-1][0];
        }

        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
}

// Solution 2 --- 思路还是二维matrix DP, 但是考虑进一步优化空间复杂度。
// 时间复杂度: O( m * n )
// 空间复杂度: O( n ), 利用滚动数组思想，对于二维matrix DP我们考虑用一维数组来存储结果
/*
因为我们在Solution 1中，最终双重循环遍历数组求解时，肯定是一行一行来的，因此我们在Solution 2中
每次求解当前行时就把上一行的结果覆盖掉即可，这样可以将空间复杂度降低，最后的结果中存储的就是最后一行的
dp[][]数组的结果的值。

画出二维cell图，来帮助分析
*/


public class Solution {
    public int uniquePaths(int m, int n) {
        // assume m and n are both valid
        int[] dp = new int[n];
        dp[0] = 1;
        for(int j = 1; j < n; j++){
            dp[j] = dp[j-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}

// Solution 3 --- 分治递归做法，将大问题进行不断divide, 这里大问题就是从起点走到[m-1][n-1]需要的unique pahts数目。
//                画出递归问题分解图，可以发现涉及到很多重复计算，Not AC, TLE
// 时间复杂度: 指数级O(2^n)
// 空间复杂度: 递归深度为O(max(m,n)), 消耗system stack
/*
public class Solution {
    public int uniquePaths(int m, int n) {
        // assume m and n are both valid
        return divideAndConquer(m-1,n-1);
    }
    private int divideAndConquer(int m, int n){
        if( m == 0 || n == 0 ){
            return 1;
        }
        return divideAndConquer(m-1, n) + divideAndConquer(m, n-1);
    }
}
*/


