// Solution 1 -- 三步翻转法
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public void rotate(int[] nums, int k) {
        if( nums == null || nums.length == 0 ){
        	return;
        }
        int length = nums.length;
        k = k % length;
        if( k == 0 ){
        	return;
        }
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - k - 1);
        reverse(nums, 0, length - 1);
    }

    private void reverse(int[] nums, int start, int end){
    	while( start <= end ){
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}


// Solution 2 --- 借助辅助数组，先将原始数组全部拷贝进入辅助数组，然后从辅助数组开始将rotate后的两部分，分别copy进原始数组
// 时间复杂度: O(n)
// 空间复杂度: O(n)

// Solution 3 --- 对原始数组从后往前的k个数字分别进行rotate循环操作，设置一个right bound, 如果某个数即将rotate的位置>=该bound就停止
//                继续下一个bound位置的数的rotate操作
// 时间复杂度: O(n)
// 空间复杂度: O(1)


public class Solution {
    public void rotate(int[] nums, int k) {
        if( nums == null || nums.length == 0 ){
        	return;
        }
        int length = nums.length;
        k = k % length;
        if( k == 0 ){
        	return;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int start = length - k;
        int crtIndex = start;
        int crtVal = nums[crtIndex];  // 第一个要移动走的元素

        while( map.size() != k && start < length ){

        	int nextIndex = (crtIndex + k) % length;

        	if( nextIndex >= (length-k) && nextIndex < length ){
        		
        		if( map.containsKey(nextIndex) ){
        			;
        		}else{
	        		int temp = nums[nextIndex];
	        		nums[nextIndex] = crtVal;
	        		crtVal = temp;
	        		crtIndex = nextIndex;  
	        		map.put(crtIndex, 1);   
	        		if( crtIndex == start ){
	        			start++;
	        			if( start >= length ){
	        				break;
	        			}
	        			crtIndex = start;
	        			crtVal = nums[crtIndex];
	        			continue;
	        		}
        		}
        	}else{
        		int temp = nums[nextIndex];
        		nums[nextIndex] = crtVal;
        		crtVal = temp;
        		crtIndex = nextIndex;
        	}
        }
    }
}
