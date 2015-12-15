// Solution 1
// 时间复杂度: O(n)
// 空间复杂度: worst case ~O(n)

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if( nums == null || nums.length == 0 ){
            return res;
        }   
        int length = nums.length;
        int left = 0, right = 1;
        for( right = 1; right < length; right++){
            if( nums[right] - nums[right-1] == 1 ){
                continue;
            }    
            res.add(helper(left, right, nums));
            left = right;
        }
        res.add(helper(left, right, nums));
        return res;
    }
    // 辅助helper函数，代码复用
    private String helper(int left, int right, int[] nums){
        String tmp = "";
        if( right - left == 1 ){
            tmp += nums[left];
        }else{
            tmp += nums[left] + "->" + nums[right-1];
        }  
        return tmp;    
    }
}
