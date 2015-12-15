// Solution 1 ---- 根据power of two的数的特性，即某一bit上有一个1其余bit都为0. 注意！！！n为负数和0的情况。
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // corner case: n为0和负数的情况，提前处理
    	if( n <= 0 ){
    		return false;
    	}
        
        if( (n & (n-1)) == 0 ){
        	return true;
        }
        return false;
    }
}


// Solution 2 --- 根据bit manipulation来检测每一个digit
// 时间复杂度: O(1)
// 空间复杂度: O(1)

public class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if( n <= 0 ){
        	return false;
        }
        int count = 0;
        for(int i = 0; i < 32; i++){
        	int mask = 1 << i;
        	if( (n & mask) != 0 ){
        		count++;
        	}
        }
        if( count == 1 ){
        	return true;
        }
        return false;
    }
}
