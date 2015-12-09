// Solution 2 -- 相当于两个同方向前进的指针，i相当于遍历指针，遍历每个元素看是否等于target, newLength相当于
//               始终指向remove target后的新数组的tail指针。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int removeElement(int[] nums, int val) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        int length = nums.length;
        int newLength = 0;
        for(int i = 0; i < length; i++){
            if( nums[i] != val ){
                nums[newLength++] = nums[i];
            }
        }
        return newLength;
    }
}

// Solution 1 -- 维护前后两个指针，前面的指针始终指向要被覆盖的位置，或者如果该位置不为target就继续前进；后指针用于copy到前面
//               覆盖掉target元素，注意覆盖过来的元素可能还是target元素，循环继续检测。注意循环结束条件。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int removeElement(int[] nums, int val) {
        
        if( nums == null || nums.length == 0 ){
        	return 0;
        }
        int length = nums.length;
        int last = length - 1; // 数组最后那个元素的index, 用后面的元素来copy覆盖前面的target元素
        int newIndex = 0;

        while( newIndex <= last ){ // 注意这里是<=
        	if( nums[newIndex] != val ){
        		newIndex++;
        		continue;
        	}
        	// if nums[newIndex] == val
        	nums[newIndex] = nums[last--];
        }
        return newIndex;
    }
}
