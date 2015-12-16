

// Solution 1 -- 注意一些特殊cases的处理，末尾为0, 正负数，overflow问题。
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    public int reverse(int x) {
        // case 1: x == 0
        if( x == 0 ){
        	return 0;
        }
        boolean isNeg = false;
        if( x < 0 ){
        	isNeg = true;
        }
        // 考虑到 -2147483648, 不能直接取绝对值会overflow, 先进行类型扩展
        long xL = (long)x;
        xL = Math.abs(xL);

        long sum = getReverse(xL);
        if( isNeg ){
        	sum = sum * (-1);
        	if( sum < Integer.MIN_VALUE ){
        		return 0;
        	}
        	return (int)sum;
        }else{
        	if( sum > Integer.MAX_VALUE ){
        		return 0;
        	}
        	return (int)sum;
        }
    }

    private long getReverse(long x){
    	long revSum = 0L;
    	while( x != 0 ){
    		revSum = revSum * 10 + x % 10;
    		x = x/10;
    	}
    	return revSum;
    }
}
