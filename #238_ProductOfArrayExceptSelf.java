// Solution 1 -- Product of array except self也就是用该元素左侧的元素的乘积和该元素右侧的元素的乘积再相乘即可。
// 时间复杂度: O(n)
// 空间复杂度: O(n)


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int length = nums.length;
        int[] result = new int[length];

        int[] left = new int[length];
        int[] right = new int[length];

        for(int i = 0; i < length; i++){
        	if( i == 0 ){
        		left[i] = 1;
        	}else{
        		left[i] = left[i-1] * nums[i-1];
        	}
        }

        for(int i = length - 1; i >= 0; i--){
        	if( i == length - 1 ){
        		right[i] = 1;
        	}else{
        		right[i] = right[i+1] * nums[i+1];
        	}
        }

        for(int i = 0; i < length; i++){
        	result[i] = left[i] * right[i];
        }
        return result;
    }
}


// Solution 2 -- Product of array except self也就是用该元素左侧的元素的乘积和该元素右侧的元素的乘积再相乘即可。
// 时间复杂度: O(n)
// 空间复杂度: O(1), 利用结果数组空间，以及局部变量, 降低空间复杂度

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return new int[0];
        } 
        int length = nums.length;
        int[] res = new int[length];
        for(int i = 0; i < length; i++){
            if( i == 0 ){
                res[i] = 1;
            }else{
                res[i] = res[i-1] * nums[i-1];
            }
        }
        // assume不会出现overflow
        int temp = 1;
        for(int i = length - 1; i >= 0; i--){
            res[i] = res[i] * temp;
            temp = temp * nums[i];
        }
        return res;
    }
}
