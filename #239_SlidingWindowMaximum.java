// Solution 2 --- 利用双端队列Deque接口的ArrayDeque类的实现，维护单调递减队列。具体看github解析
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// https://github.com/zhangxin0804/leetcode-2/blob/master/Array/SlidingWindowMaximum.java


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       	
       	if( nums == null || nums.length < k || k == 0 ){
       		return new int[0];
       	}
       	int length = nums.length;
       	// result array
       	int[] res = new int[length - k + 1];
       	int newIndex = 0;
       	Deque<Integer> doubleEndedQueue = new ArrayDeque<Integer>();
       	int i = 0;

       	while( i < length ){
       		while( !doubleEndedQueue.isEmpty() && doubleEndedQueue.peek() < i + 1 - k ){
       			doubleEndedQueue.poll();
       		}

       		while( !doubleEndedQueue.isEmpty() && nums[doubleEndedQueue.peekLast()] < nums[i]   ){
       			doubleEndedQueue.pollLast();
       		}
       		doubleEndedQueue.offer(i);
       		if( i >= k - 1 ){
       			res[newIndex++] = nums[doubleEndedQueue.peek()];
       		}
       		i++;
       	}

       	return res;

    }

}


// Solution 1 --- 暴力brute force解法，外层循环移动sliding window, 内层循环遍历window检测最大值。可以AC
// 时间复杂度: O( n * k ), k 为 window size
// 空间复杂度: O(n)
/*
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       	
       	if( nums == null || nums.length < k || k == 0 ){
       		return new int[0];
       	}
       	int length = nums.length;
       	// result array
       	int[] res = new int[length - k + 1];
       	int newIndex = 0;
       	// sliding window left boundary and right boundary
       	int left = 0, right = 0; 

       	for( right = 0; right < length; right++){
       		if( right < k - 1 ){
       			continue;
       		}else if( right == k - 1 ){
       			res[newIndex++] = getMax(nums, left, right);
       		}else{
       			left++;
       			res[newIndex++] = getMax(nums, left, right);
       		}
       	}
       	return res;
    }

    private int getMax(int[] nums, int i, int j){
    	int max = nums[i];
    	for(int k = i + 1; k <= j; k++){
    		max = Math.max(max, nums[k]);
    	}
    	return max;
    }
}
*/
