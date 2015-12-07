// Solution 1 ------ 关键是先确定出如果有overlap, 那么overlap的面积如何表示。画图！！
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    

    	int leftBottomX = Math.max(E, A);
    	int leftBottomY = Math.max(B, F);
    	int rightUpX = Math.min(C, G);
    	int rightUpY = Math.min(D, H);

    	int overlap = 0;
    	if( leftBottomX > rightUpX || leftBottomY > rightUpY ){
    		overlap = 0;
    	}else{
    		overlap = (rightUpX - leftBottomX) * (rightUpY - leftBottomY);
    	}
    	
    	int total = (C-A) * (D-B) + (G-E) * (H-F) - overlap;
    	return total;
    }
}
