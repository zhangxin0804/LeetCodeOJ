/*

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/


// Solution 1 ---- 先排序，然后找出第kth大，注意第kth大和实际index之间的off-one差别。
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        int length = nums.length;
        return nums[ length - k ];
    }
}


// Solution 2  ---- 典型的top K_找第k大第k小问题, 既然是找第kth大的元素，因此可以维护一个size为k的minHeap
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k), 堆heap的size消耗
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int length = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int heapSize = k;

        for(int i = 0; i < length; i++){
            if( minHeap.size() < heapSize ){
                minHeap.offer( nums[i] );
            }else{
                if( nums[i] > minHeap.peek() ){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}


// Solution 3 ---- 利用快速选择算法 quick select
// 时间复杂度: 平均为O(n), worst case ~ O(n^2)
// 空间复杂度: 平均O(logn), worst case ~ O(n)

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    private int findKthSmallest(int[] nums, int left, int right, int kth){
        int leftCopy = left;
        int rightCopy = right;
        int pivot = nums[left]; // 始终选择左边界Index的元素为pivot元素
        while( leftCopy < rightCopy ){

            // 从右往左，找到第一个小于等于pivot元素的数
            while( leftCopy < rightCopy && nums[rightCopy] > pivot ){
                rightCopy--;
            }
            if( leftCopy < rightCopy ){
                //将nums[tempRight]填到nums[tempLeft]中，nums[tempRight]就形成了一个新的坑, SWAP
                swap(nums, leftCopy, rightCopy);
            }
            // 从左往右，找到第一个大于pivot元素的数
            while( leftCopy < rightCopy && nums[leftCopy] <= pivot ){
                leftCopy++;
            }
            if( leftCopy < rightCopy ){
                //将nums[tempLeft]填到nums[tempRight]中，nums[tempLeft]又形成了一个新的坑, SWAP
                swap(nums, leftCopy, rightCopy);
            }
        }
        //退出时, tempLeft == tempRight, 再将pivot元素填入坑中
        nums[leftCopy] = pivot;
        // 注意是从小到大，找第kth, 因此k是从1开始的，与边界有off-one的差别.
        if( leftCopy + 1 == kth ){
            return nums[leftCopy];
        }else if( kth < leftCopy + 1 ){
            return findKthSmallest(nums, left, leftCopy - 1, kth);
        }else{
            return findKthSmallest(nums, leftCopy + 1, right, kth);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
