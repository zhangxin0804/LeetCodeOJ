// Solution 1 --- 先排序sorting, 枚举其中2个数，剩下的两个数用two pointers思想左右夹逼即可。
// 时间复杂度: O(n^3)
// 空间复杂度: 如果不算解集空间就为O(1); 如果算上解集空间就为O(k), k为解集个数。

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if( nums == null || nums.length == 0 ){
        	return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for(int first = 0; first < length - 3; first++){
        	if( first != 0 && nums[first] == nums[first-1] ){
        		continue;
        	}
        	for(int second = first + 1; second < length - 2; second++){
        		if( (second != first + 1) && (nums[second] == nums[second-1]) ){
        			continue;
        		}
        		int third = second + 1, forth = length - 1;
        		while( third < forth ){
        			if( nums[first] == target - nums[second] - nums[third] - nums[forth] ){
        				List<Integer> each = new ArrayList<Integer>();
        				each.add(nums[first]);
        				each.add(nums[second]);
        				each.add(nums[third]);
        				each.add(nums[forth]);
        				res.add(each);
        				third++;
        				while( third < forth && (nums[third] == nums[third-1]) ){
        					third++;
        				}
        				forth--;
        				while( third < forth && (nums[forth] == nums[forth+1]) ){
        					forth--;
        				}
        			}else if( nums[first] < target - nums[second] - nums[third] - nums[forth] ){
        				third++;
        			}else{
        				forth--;
        			}
        		}
        	}
        }
        return res;
    }
}
