// Solution 1 -- 利用位操作中的Get Bit, 注意位运算优先级
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int count = 0;
        // 注意因为题目说n当做unsigned int, 因此最高位不为符号位，而是一个有效位需要被检测
        for(int i = 0; i < 32; i++){
        	int mask = 1 << i;
        	if( (mask & n) != 0 ){
        		count++;
        	}
        }
        return count;
    }
}
