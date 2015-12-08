

// Solution 1  ---- DFS, 类似flood fill算法
// 时间复杂度: O(m*n)
// 空间复杂度: O(mn), 递归深度

public class Solution {
    public int numIslands(char[][] grid) {
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
        	return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if( grid[i][j] == '1' ){
        			dfs(grid, i, j);
        			result += 1;
        		}
        	}
        }
        return result;
    }
    private void dfs(char[][] grid, int i, int j){
    	if( i == grid.length || i < 0 || j < 0 || j == grid[0].length ){
    		return;
    	}
    	if( grid[i][j] == '0' ){
    		return;
    	}
    	grid[i][j] = '0';
    	dfs(grid, i+1, j);
    	dfs(grid, i-1, j);
    	dfs(grid, i, j+1);
    	dfs(grid, i, j-1);
    }
}




// Solution 2  ---- BFS,关键是队列中如何存放下一层的信息，是构建新的类Point还是存放下一层元素的行列坐标，然后一次读取两个值即行列坐标再去找值。
// 时间复杂度:  O(m*n)
// 空间复杂度:  O(m*n)

public class Solution {
    public int numIslands(char[][] grid) {
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
        	return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        boolean[][] markArry = new boolean[row][col];
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if( grid[i][j] == '1' ){
        			Queue<Integer> queue = new LinkedList<Integer>();
        			queue.offer(i);
        			queue.offer(j);
        			markArry[i][j] = true;
        			while( !queue.isEmpty() ){
        				int size = queue.size()/2;
        				for(int k = 0; k < size; k++){
        					int tmpRow = queue.poll();
        					int tmpCol = queue.poll();
        					grid[tmpRow][tmpCol] = '0';

        					if( isValid(grid, tmpRow+1, tmpCol, markArry) ){
        						queue.offer(tmpRow+1);
        						queue.offer(tmpCol);
        						markArry[tmpRow+1][tmpCol] = true;
        					}
        					if( isValid(grid, tmpRow-1, tmpCol, markArry) ){
        						queue.offer(tmpRow-1);
        						queue.offer(tmpCol);
        						markArry[tmpRow-1][tmpCol] = true;
        					}
        					if( isValid(grid, tmpRow, tmpCol+1, markArry) ){
        						queue.offer(tmpRow);
        						queue.offer(tmpCol+1);
        						markArry[tmpRow][tmpCol+1] = true;
        					}
        					if( isValid(grid, tmpRow, tmpCol-1, markArry) ){
        						queue.offer(tmpRow);
        						queue.offer(tmpCol-1);
        						markArry[tmpRow][tmpCol-1] = true;
        					}
        				}
        			}
        			result += 1;
        		}
        	}
        }
        return result;
    }
    private boolean isValid(char[][] grid, int row, int col, boolean[][] markArry){
    	if( row == grid.length || row < 0 || col == grid[0].length || col < 0 ){
    		return false;
    	}
    	if( grid[row][col] == '0' ){
    		return false;
    	}
    	if( markArry[row][col] == true ){
    		return false;
    	}
    	return true;
    }
}


// Solution 3  -- 仍然是BFS思想，想办法进一步减少空间复杂度。利用二维matrix的元素值本身，我们提前对其进行set 0操作即可。
//                避免使用HashMap或者标记数组来记录visited cell.
// 回想之前有道题，为了避免使用标记数组markArry, 我们在元素cell上将值改为特殊字符'#'的处理。再复原。
// 时间复杂度: O(m*n)
// 空间复杂度: O(m*n)

public class Solution {
    public int numIslands(char[][] grid) {
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( grid[i][j] == '1' ){
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.offer(i);
                    queue.offer(j);
                    while( !queue.isEmpty() ){
                        int size = queue.size();
                        // 注意for循环的size!!!是size/2, 因为这里我们是每次offer两个坐标
                        // 表示一个cell
                        for(int k = 0; k < size/2; k++){
                            int crtRow = queue.poll();
                            int crtCol = queue.poll();
                            if( isValid(grid, crtRow+1, crtCol) ){
                                grid[crtRow+1][crtCol] = '0';
                                queue.offer(crtRow+1);
                                queue.offer(crtCol);
                            }
                            if( isValid(grid, crtRow-1, crtCol) ){
                                grid[crtRow-1][crtCol] = '0';
                                queue.offer(crtRow-1);
                                queue.offer(crtCol);
                            }
                            if( isValid(grid, crtRow, crtCol+1) ){
                                grid[crtRow][crtCol+1] = '0';
                                queue.offer(crtRow);
                                queue.offer(crtCol+1);
                            }
                            if( isValid(grid, crtRow, crtCol-1) ){
                                grid[crtRow][crtCol-1] = '0';
                                queue.offer(crtRow);
                                queue.offer(crtCol-1);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isValid(char[][] grid, int i, int j){
        if( i < 0 || i == grid.length || j < 0 || j == grid[0].length ){
            return false;
        }
        if( grid[i][j] == '0' ){
            return false;
        }
        return true;
    }
}
