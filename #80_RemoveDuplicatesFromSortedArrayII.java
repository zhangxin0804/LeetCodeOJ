
// Solution 1 -- 思路其实类似I的思路，用一个变量newIndex, 始终指向下一个要被当前或者后面元素覆盖的位置，同时也可以作为
//               new length返回，初始化时newIndex = 1, 如果数组就只有一个元素，则不进入for循环直接return newIndex即新长度
//               如果数组多个元素，我们就从i = 1开始遍历，始终check nums[i]和nums[i-1]的关系，如果不重复，意味着当前这个元素
//               的位置是正确的，我们仍然也将其拷贝到newIndex位置(其实它就在这个位置), 然后newIndex又继续前进到下一个位置
//               如果有duplicates, 只要其dup的个数没到dupMax就可以继续完成copy值，同时更新count. 如果dup的个数到达dupMax,
//               就继续往后前进跳过这些dup的值，直到遇到前后不dup的或者数组结束。
//               如果前进到了末尾，则可以直接Break; 如果前进到了一个不再duplicates的元素，此时i等于这个新的元素，, 我们只需要
//               将i退后一个位置，再次循环开始时，会因为nums[i] != nums[i-1]而进入else分支完成copy值。然后继续下去。
//               在II的题目中，我们只需要在多维护一个count用来表示当前累积到了多少个duplicates即可。稍微处理下。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        int length = nums.length;
        // duplicates at most times
        int dupMax = 2;
        // 从Index = 1的元素开始，进行index和index-1之间的比较。
        int newIndex = 1;
        int count = 1;
        for(int i = 1; i < length; i++){
            if( nums[i] == nums[i-1] ){
                if( count < dupMax ){
                   nums[newIndex++] = nums[i];
                   count++;
                }else{
                    while( i < length && nums[i] == nums[i-1] ){
                        i++;
                    }
                    if( i != length ){
                        //进到这里意味着nums[i] != nums[i-1], 因此i退后一个
                        //循环再开始时，会进入到下面else分支完成拷贝值。
                        i = i-1;
                    }
                }
            }else{
                nums[newIndex++] = nums[i];
                count = 1;
            }
        }
        return newIndex;
    }
}
