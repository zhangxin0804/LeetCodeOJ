
// Solution 1  ---- step_wise linear search, 从左下开始，往右上前进
// 时间复杂度: O(m+n)
// 空间复杂度: O(1)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }        
        int row = matrix.length;
        int col = matrix[0].length;
        if( target < matrix[0][0] || target > matrix[row - 1][col - 1] ){
            return false;
        }
        int i = row - 1, j = 0;
        while( i >= 0 && j < col ){
            // 先从左下，往上走
            while( i >= 0 && j < col && matrix[i][j] > target ){
                i--;
            }
            // 再往右走
            while( i >= 0 && j < col && matrix[i][j] < target ){
                j++;
            }
            // 如果在上面两次连续移动中，有遇到target, 则返回
            if(  i >= 0 && j < col ){
                if( matrix[i][j] == target ){
                    return true;
                }
            }
        }
        return false;
    }
}
