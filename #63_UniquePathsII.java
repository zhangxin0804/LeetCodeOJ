/*

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

*/

// Solution 1 --- Count类型DP问题，二维Matrix DP问题。注意约束条件障碍物的出现。
// 时间复杂度:
// 空间复杂度:

// 状态定义：dp[i][j]表示从[0][0]走到[i][j]位置的unique paths数目。
// 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1], 研究走到[i][j]这个点之前的一步。这里还要考虑障碍物的存在。
// 初始化：因为是二维matrix, 再根据状态转移方程可知，需要初始化第一行和第一列。也要考虑障碍物的存在。
// 结果：dp[m-1][n-1]

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // assume obstacleGrid is valid
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];
        // initialization
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int j = 1; j < colNum; j++){
            if( obstacleGrid[0][j] != 1 ){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i < rowNum; i++){
            if( obstacleGrid[i][0] != 1 ){
                dp[i][0] = dp[i-1][0];
            }
        }
        // recurrent formula
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < colNum; j++){
                if( obstacleGrid[i][j] != 1 ){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        // answer
        return dp[rowNum-1][colNum-1];
    }
}


// Solution 2 --- 考虑进一步优化空间，看是否能利用滚动数组解决。别忘了还有障碍物存在这个约束条件。
//                由于此题引入了障碍物，因此首行和首列不一定都为全1，还是画图来理解！！
// 时间复杂度: O(m*n)
// 空间复杂度: O(n)
/*
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // assume obstacleGrid is valid
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        // initialization
        int[] dp = new int[colNum];
        dp[0] = (obstacleGrid[0][0]==1)?0:1;
        for(int j = 1; j < colNum; j++){
            if( obstacleGrid[0][j] != 1 ){
                dp[j] = dp[j-1]; 
            }
        }
        for(int i = 1; i < rowNum; i++){
            // 因为首列不一定是全1了，所以要做判断更新。
            if( obstacleGrid[i][0] == 1 ){
                dp[0] = 0;
            }
            for(int j = 1; j < colNum; j++){
                if( obstacleGrid[i][j] != 1 ){
                    dp[j] = dp[j-1] + dp[j];    
                }else{
                    // 别忘了这里，如果当前为障碍物，值就应该为0也要更新回去。
                    dp[j] = 0;
                }
            }
        }
        return dp[colNum-1];
    }
}
*/
