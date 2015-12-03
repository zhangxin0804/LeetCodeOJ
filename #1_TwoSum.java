// Solution 0 -- brute force双重循环
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
// 注意：数组长度不能小于2的corner case

/*
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if( nums == null || nums.length < 2 ){
        	return result;
        }
        int length = nums.length;
        for(int i = 0; i < length - 1; i++){
        	for(int j = i + 1; j < length; j++){
        		if( nums[i] + nums[j] == target ){
        			result[0] = i + 1;
        			result[1] = j + 1;
        			return result;
        		}
        	}
        }
        return result;
    }
}
*/

// Solution 1 ---- 根据A+B=C的等式关系，再根据HashMap来加速查找，遍历过的存储于HashMap, 继续遍历根据target - current来查找
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// 注意：数组长度不能小于2的corner case

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        if( nums == null || nums.length == 0 || nums.length < 2 ){
            return res;
        }
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < length; i++){
            int tmp = target - nums[i];
            if( map.containsKey(tmp) ){
                res[0] = map.get(tmp);
                res[1] = i + 1;
                return res;
            }else{
                map.put(nums[i], i+1);
            }
        }
        return res;  
    }
}

// Solution 2 -- 由于本题涉及返回的是index, 所以如果要用sorting + two pointers的方法，就要先想办法把index存储好。
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
// 注意：数组长度不能小于2的corner case
/*
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        if( nums == null || nums.length == 0 || nums.length < 2 ){
            return res;
        }
        int length = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < length; i++){
            if( map.containsKey(nums[i]) ){
                map.get(nums[i]).add(i+1);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i+1);
                map.put(nums[i], list);
            }
        }
        Arrays.sort(nums);
        int left = 0, right = length - 1;
        while( left < right ){
            // 注意assume不会出现overflow
            if( nums[left] + nums[right] == target ){
                if( nums[left] == nums[right] ){
                   int tmp1 = map.get(nums[left]).get(0); 
                   int tmp2 = map.get(nums[left]).get(1);  
                   res[0] = Math.min(tmp1, tmp2);
                   res[1] = Math.max(tmp1, tmp2);
                   return res;
                }else{
                   int tmp1 = map.get(nums[left]).get(0); 
                   int tmp2 = map.get(nums[right]).get(0);
                   res[0] = Math.min(tmp1, tmp2);
                   res[1] = Math.max(tmp1, tmp2);
                   return res;
                }
            }else if( nums[left] + nums[right] < target ){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
*/
