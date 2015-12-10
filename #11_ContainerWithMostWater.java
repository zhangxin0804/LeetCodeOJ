// Solution 2 --- 木桶原理，短板效应。容积由最短的那个木板的高度来决定。two pointers维护一个window, 从两端往中间夹逼(关键)。
//                关键是如何移动边界!! 因为要想有更大的面积，一定不是收缩非短板的那个边，因为这样只会让面积更小。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int maxArea(int[] height) {
        if( height == null || height.length < 2 ){
            return 0;
        }
        int length = height.length;
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = length - 1;
        while( left < right ){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right-left) );
            if( height[left] <= height[right] ){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}

// Solution 1 --- brute force, Not AC, TLE
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)

public class Solution {
    public int maxArea(int[] height) {
        if( height == null || height.length == 0 ){
        	return 0;
        }
        int length = height.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length - 1; i++){
        	for(int j = i + 1; j < length; j++){
        		int area = (j - i) * Math.min(height[i], height[j]);
        		max = Math.max(max, area);
        	}
        }
        return max;
    }
}
