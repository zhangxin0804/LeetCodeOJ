
// Solution 1 --- 递归回溯暴力枚举搜索 + 标记数组
// 时间复杂度: O( m * n * 4 ^ k ), k为字符串的长度
// 空间复杂度: O(k) + O(m*n), k为字符串的长度，也即递归深度, O(m*n)为标记数组空间

public class Solution {
    public boolean exist(char[][] board, String word) {

        if( board == null || board.length == 0 || board[0].length == 0 ){
        	return false;
        }
        if( word == null || word.length() == 0 ){
        	return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] markArr = new boolean[row][col];
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if( wordExist(board, i, j, word, markArr, 0) ){
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean wordExist(char[][] board, int i, int j, String word, boolean[][] markArr, int index){

    	if( index == word.length() ){
    		return true;
    	}
    	if( i >= board.length || i < 0 || j >= board[0].length || j < 0 ){
    		return false;
    	}
    	if( markArr[i][j] == true ){
    		return false;
    	}
    	if( word.charAt(index) !=  board[i][j] ){
    		return false;
    	}
    	markArr[i][j] = true;
    	boolean result = wordExist(board, i + 1, j, word, markArr, index + 1) ||
    					 wordExist(board, i, j + 1, word, markArr, index + 1) ||
    					 wordExist(board, i - 1, j, word, markArr, index + 1) ||
    					 wordExist(board, i, j - 1, word, markArr, index + 1);

    	markArr[i][j] = false;
    	return result;
    }
}


// Solution 2 --- DFS, 假设只会出现letter, 因此对于访问过的cell 我们用一个特殊字符'#'标记来避免使用标记数组，节省空间
// 时间复杂度: O( m * n * 4 ^ k ), k为字符串的长度
// 空间复杂度: O(k), k为字符串的长度，也即递归深度

public class Solution {
    public boolean exist(char[][] board, String word) {

        if( board == null || board.length == 0 || board[0].length == 0 ){
            return false;
        }
        if( word == null || word.length() == 0 ){
            return false;
        }
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( wordExist(board, i, j, word, 0) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExist(char[][] board, int i, int j, String word, int index){

        if( index == word.length() ){
            return true;
        }
        if( i >= board.length || i < 0 || j >= board[0].length || j < 0 ){
            return false;
        }
        if( board[i][j] == '#' ){
            return false;
        }
        if( word.charAt(index) !=  board[i][j] ){
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean result = wordExist(board, i + 1, j, word, index + 1) ||
                         wordExist(board, i, j + 1, word, index + 1) ||
                         wordExist(board, i - 1, j, word, index + 1) ||
                         wordExist(board, i, j - 1, word, index + 1);

        board[i][j] = tmp;
        return result;
    }
}

