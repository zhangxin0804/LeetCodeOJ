// Solution 0 --- 因为解集需要non-descneding order, 因此先排序后，然后brute force三重循环找triplete, 注意no duplicate
// 时间复杂度: O(n^3), 三重循环，其中排序O(nlogn)
// 空间复杂度: O(1), 不算解集空间。

// Solution 1 --- 先排序sorting, 枚举其中1个数，剩下两个数，two pointers夹逼，注意no duplicates
// 时间复杂度: O(n^2)，其中排序O(nlogn)
// 空间复杂度: O(1)


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( nums == null || nums.length < 3 ){
        	return res;
        }
        int length = nums.length;
        // sorting, make sure non-descending order
        Arrays.sort(nums);
        int first;
        for( first = 0; first < length - 2; first++){
        	// skip duplicate situations
        	if( first != 0 && nums[first] == nums[first-1] ){
        		continue;
        	}
        	int second = first + 1;
        	int third = length - 1;
        	while( second < third ){
        		// assume不会出现overflow
        		if( nums[first] + nums[second] + nums[third] == 0  ){
        			List<Integer> each = new ArrayList<Integer>();
        			each.add(nums[first]);
        			each.add(nums[second]);
        			each.add(nums[third]);
        			res.add(each);
        			// skip duplicate situations
        			second++;
        			while( second < third && nums[second] == nums[second-1] ){
        				second++;
        			}
        			// skip duplicate situations
        			third--;
        			while( second < third && nums[third] == nums[third+1] ){
        				third--;
        			}        			
        		}else if( nums[first] + nums[second] + nums[third] < 0 ){
        			second++;
        		}else if( nums[first] + nums[second] + nums[third] > 0 ){
        			third--;
        		}
        	}
        }
        return res;
    }
}

