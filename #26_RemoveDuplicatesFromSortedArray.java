// Solution 1 -- 要求O(1)空间in-place解决, 这个题很容易想昏，容易写错！！！
//            -- 思路，用一个变量newIndex, 始终指向下一个要被当前或者后面元素覆盖的位置，同时也可以作为
//               new length返回，初始化时newIndex = 1, 相当于这个newIndex始终作为一个tail指针维护removeDup后的数组。

// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        int length = nums.length;
        int newIndex = 1;
        for(int i = 1; i < length; i++){
            if( nums[i] != nums[i-1] ){
                nums[newIndex++] = nums[i];
            }
        }
        return newIndex;
    }
}
