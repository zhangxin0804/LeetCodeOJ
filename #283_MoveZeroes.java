// Solution 2 -- two pointers, 一个left指针用于维护左侧非0元素的boundary, 另一个遍历指针即可。有点儿类似sort colors那个题
//               但是sort colors那个题是相当于把元素partition成3部分，因此还需要一个right boundary指针，而这个题目。只需要
//               partition成2部分。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public void moveZeroes(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return;
        }
        int length = nums.length;
        // left指针用于维护左侧非0元素的boundary
        int left = 0;
        // i为遍历指针。
        for(int i = 0; i < length; i++){
            if( nums[i] != 0 ){
                swap(nums, i, left);
                left++;
            }
        }
    }
    // 辅助helper函数用于swap元素。
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Solution 1 -- 利用extra space先对原始数组进行copy, 然后再将所有非0全部复制回去，再copy 0过去剩下的位置。
// 时间复杂度: O(n)
// 空间复杂度: O(n)
/*
public class Solution {
    public void moveZeroes(int[] nums) {
        if( nums == null || nums.length == 0 ){
        	return;
        }
        int length = nums.length;
        int[] copyArr = new int[length];
        int j = 0;
        for(int i = 0; i < length; i++){
        	copyArr[j++] = nums[i];
        }
        int count = 0;
        for(int i = 0; i < length; i++){
        	if( copyArr[i] != 0 ){
        		nums[count++] = copyArr[i];
        	}
        }
        for(int i = count; i < length; i++){
        	nums[i] = 0;
        }
    }
}
*/
