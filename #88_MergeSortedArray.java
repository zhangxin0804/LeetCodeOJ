// Solution 1 --- 对两个sorted array进行merge, 且是merge到其中一个较大size的array里，因此考虑从后往前backwards copy元素
//                注意某个数组提前结束后，对另一个数组的继续拷贝处理
// 时间复杂度: O(m+n)
// 空间复杂度: O(1)
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int count = m + n - 1;
        m--;
        n--;
        while( m >= 0 && n >= 0 ){
            if( nums1[m] >= nums2[n] ){
                nums1[count--] = nums1[m];
                m--;
            }else{
                nums1[count--] = nums2[n];
                n--;
            }
        }
        while( n >= 0 ){
            nums1[count--] = nums2[n];
            n--;           
        }
    }
}
