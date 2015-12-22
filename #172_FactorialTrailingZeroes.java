// Solution 1 --- trailing 0的个数取决于乘积包含10的个数，乘积包含10的个数取决于pair(2,5)相乘的个数，2的个数始终多于5的个数。
//                因此最终取决于5的个数，然后需要注意如果n = 5^2, 5^3, 5^4这种时，就会多贡献5出来。因此n/5后还要继续判断n=n/5的n
//                是否还包含5，同理下去。

// 时间复杂度: O(logn)
// 空间复杂度: O(1)


public class Solution {
    public int trailingZeroes(int n) {
        if( n < 0 ){
        	return 0;
        }
        int count = 0;
        while( n >= 5 ){
        	count += n/5;
        	n = n/5;
        }
        return count;
    }
}
