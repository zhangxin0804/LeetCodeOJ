
// Solution 1 --- 数组长度为n就是说希望的数列是0,1,2,3,....,n这n+1个数，但是由于少了一个数，所以长度只有n，先根据数组长度得到预期的sum值，
// 				  再统计当前sum值，再求差找Missing, 注意为了防止求和overflow, 用long类型变量存储，最后在转型返回。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int missingNumber(int[] nums) {
        if( nums == null || nums.length == 0 ){
        	return -1;
        }
        int length = nums.length;
        long expected = (0 + length) * (length + 1)/2;
        long sum = 0L;
        for(int i = 0; i < length; i++){
        	sum += nums[i];
        }
        return (int)(expected-sum);
    }
}


// Solution 2 --- 采用类似Leetcode #41 First Missing Positive那个题目的做法，根据元素值和其对应的index关系。
//                注意：如果题目是missing了多个numbers, 则只能考虑用Solution2来解决了。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int missingNumber(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return -1;
        }
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if( nums[i] == i ){
                continue;
            }
            while( nums[i] != i && nums[i] < length ){
                swap(nums, i, nums[i]);
            }
        }
        for(int i = 0; i < length; i++){
            if( i != nums[i] ){
                return i;
            }
        }
        return length;
    }   
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
