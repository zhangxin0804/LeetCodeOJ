
// Solution 1 --- 3sum问题的变种，大的思路都是一样的。注意最后返回的是离target最近的那组3个数的sum和。注意corner case, length < 3
// 时间复杂度: O( n^2 )
// 空间复杂度: O(1)

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	// corner case
        if( nums == null || nums.length == 0 || nums.length < 3 ){
        	return -1;
        }
        int length = nums.length;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;

        int first;
        for( first = 0; first < length - 2; first++){
        	// duplicates ?
        	int second = first + 1;
        	int third = length - 1;
        	while( second < third ){
        		// assume no overflow
        		int temp = nums[first] + nums[second] + nums[third];
        		if( Math.abs(temp - target) <= closest ){
        			closest = Math.min(Math.abs(temp - target), closest);
        			sum = temp;
        		}
        		if( temp == target ){
        			return target;
        		}else if( temp < target ){
        			second++;
        		}else if( temp > target ){
        			third--;
        		}
        	}
        }
        return sum;
    }
}
