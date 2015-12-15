// Solution 1 -- 位操作 Get Bits + Update Bits
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    
        int res = 0;
        for(int i = 0; i < 32; i++){
            int mask = (1<<i);
            if( (mask & n) != 0 ){
                res |= (1 << (31-i));
            }
        }
        return res;
    }
}
