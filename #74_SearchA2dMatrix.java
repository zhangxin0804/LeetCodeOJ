// Solution 1 --- 进行两次binary search, 先在第一列sorted 元素中找到target元素应该出现在哪一行，然后再从这一行sorted元素中找target。
// 时间复杂度: O(logM + logN)
// 空间复杂度: O(1)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row - 1;
        while( start + 1 < end ){
            int middle = start + ((end-start) >> 1);
            if( matrix[middle][0] == target ){
                return true;
            }else if( matrix[middle][0] > target ){
                end = middle;
            }else{
                start = middle;
            }
        }
        if( matrix[start][0] == target || matrix[end][0] == target ){
            return true;
        }
    
        int targetRow = 0;
        
        if( target > matrix[end][0] ){
            targetRow = end;
        }else if( target > matrix[start][0] && target < matrix[end][0] ){
            targetRow = start;
        }
        start = 0;
        end = col - 1;
        while( start + 1 < end ){
            int middle = start + ((end-start) >> 1);
            if( matrix[targetRow][middle] == target ){
                return true;
            }else if( matrix[targetRow][middle] > target ){
                end = middle;
            }else{
                start = middle;
            }            
        }
        if( matrix[targetRow][start] == target || matrix[targetRow][end] == target ){
            return true;
        }
        return false;
    }
}

// Solution 2 -- 可以将二维数组看做是一个很长的一维数组，用一个index来访问二维数组的元素，问题转化到在single sorted array上找target. 
// 时间复杂度: O( log(m*n) )
// 空间复杂度: O(1)
// 注意：在end计算时涉及到row * col相乘，有可能会有overflow的情况出现。

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }   
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while( start + 1 < end ){
            int middle = start + ((end-start) >> 1);
            int i = middle/col, j = middle%col;
            if( matrix[i][j] == target ){
                return true;
            }
            if( matrix[i][j] > target ){
                end = middle;
            }else{
                start = middle;
            }
        }
        if( matrix[start/col][start%col] == target ){
            return true;
        }else if( matrix[end/col][end%col] == target ){
            return true;
        }
        return false;
    }
}

// Solution 3 -- 因为一行一行看过去其实就是一个ascending order, 因此每一行都是ascending order, 每一列也是ascending order
//               所以类似search a 2d matrix II一样，可以采用step-wise linear search方法。
// 时间复杂度: O(m+n)
// 空间复杂度: O(1)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row-1, j = 0;
        while( i >= 0 && j < col ){
            while( i >= 0 && j < col && matrix[i][j] > target ){
                i--;
            }
            while( i >= 0 && j < col && matrix[i][j] < target ){
                j++;
            }
            if( i >= 0 && j < col ){
                if( matrix[i][j] == target ){
                    return true;
                }
            }
        }
        return false;
    }
}
