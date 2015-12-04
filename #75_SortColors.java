/*

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.

First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array 
with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

*/

// Solution 0 -- 调用库函数Arrays.sort()
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)

/*
public class Solution {
    public void sortColors(int[] nums) {
       if( nums == null || nums.length == 0 ){
       		return;
       } 

       Arrays.sort(nums);
    }
}
*/

// Solution 1 ---- 因为数组的元素的值是在一定范围之内，比如1到k, 因此可以利用counting sort计数排序的思想
//                 来实现线性时间的排序算法.

// 时间复杂度: O(n), two-pass algorithm
// 空间复杂度: O(k), k 为元素值的范围

public class Solution {
    public void sortColors(int[] nums) {

    	if( nums == null || nums.length == 0 ){
    		return;
    	}
    	// 元素值范围为[0,1,2]
    	int length = nums.length;
    	int[] copyArr = new int[3];
    	for(int i = 0; i < length; i++){
    		copyArr[nums[i]] = copyArr[nums[i]] + 1;
    	}
    	int crt = length - 1;
    	for(int i = copyArr.length - 1; i >= 0; i--){
    		while( copyArr[i] > 0 ){
    			nums[crt--] = i;
    			copyArr[i] = copyArr[i] - 1;
    		}
    	}
  }
}

// Solution 2 -- 利用快排pivot思想，设定3个指针，左右两侧各1个指针用于维护左右两侧的排序好的元素，中间一个指针用于遍历。
/*

1. 左侧指针left, 始终指向属于左侧部分的那个元素即将要被SWAP到的那个位置。
2. 右侧指针right, 始终指向属于右侧部分的那个元素即将要被SWAP到的那个位置。
3. 中间指针crt, 用于遍历数组中的元素。

注意：遇到后半部分的元素时我们将其和后面的位置SWAP后，被换回来的数还得再次检测，而不能直接crt++, 因为我们是从左往右遍历的，
意味着从crt到之前的位置都是已经sorted的了，但是后面SWAP回来的数有可能还是属于前面部分的数所以还得再次循环检测。不能直接跳过！！

*/

// 时间复杂度: O(n), one-pass algorithm
// 空间复杂度: O(1)

public class Solution {
    public void sortColors(int[] nums) {

    	if( nums == null || nums.length == 0 ){
    		return;
    	}

    	int length = nums.length;
    	int left = 0, right = length - 1; // 左侧和右侧的两个指针，用于维护已经被重置过的sorted元素
    	int pivot = 1; // pivot元素，整个的分离过程以pivot为界, 左边存放0, 右边存放2, 中间存放1
    	int crt = 0; // 遍历指针

    	for( crt = 0; crt <= right; crt++ ){

    		if( nums[crt] == pivot ){
    			continue;
    		}
    		if( nums[crt] < pivot ){
    			swap(nums, left, crt);
    			left++;
    		}else if( nums[crt] > pivot ){
    			swap(nums, crt, right);
    			right--;
    			crt--; // 抵消该分支结束后的for循环中的crt++
    		}
    	}
    }
 	 // helper function
  	private void swap(int[] nums, int i, int j){
  		int tmp = nums[i];
  		nums[i] = nums[j];
  		nums[j] = tmp;
  	}
}


// Solution 3 -- 巩固一下quick sort, 分治递归思想，挖坑填数方法。
// 时间复杂度: average ~ O(nlogn), worst ~ O(n^2)
// 空间复杂度: average ~ O(logn), worst ~ O(n)
public class Solution {
    public void sortColors(int[] nums) {
        // assume nums not empty or not null
        quickSort(nums, 0, nums.length-1);
    }
    private void quickSort(int[] nums, int left, int right){
        // recursive terminated
        if(left >= right){
           return; 
        }
        int pivot = nums[left]; // 始终选择待排序区间的首元素作为Pivot
        int leftCopy = left;
        int rightCopy = right;
        while(leftCopy<rightCopy){
            while( leftCopy<rightCopy && nums[rightCopy] > pivot ){
                    rightCopy--;
            }
            if( leftCopy < rightCopy ){
                swap(nums, leftCopy, rightCopy);
            }  
            while( leftCopy<rightCopy && nums[leftCopy] <= pivot ){
                leftCopy++;
            }
            if( leftCopy < rightCopy ){
                swap(nums, leftCopy, rightCopy);  
            }
        }
        nums[leftCopy] = pivot;
        quickSort(nums, left, leftCopy-1);
        quickSort(nums, leftCopy+1, right);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
