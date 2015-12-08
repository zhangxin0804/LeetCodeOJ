
// Solution 1 --- 循环遍历，brute force解法
// 时间复杂度: O(k*n), k 为平均每个字符串的长度, n为字符串的个数
// 空间复杂度: O(m), m为common prefix的长度，算是解集空间吧。

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ){
        	return "";
        }
        int length = strs.length;
        // assume不会有空字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            // 选定一个基准字符
        	char c = strs[0].charAt(i);
        	for(int j = 1; j < length; j++){
        	    // 如果某个字符串结束了，或者某个地方字符不等了，就可以直接返回了。
        		if( i == strs[j].length() || strs[j].charAt(i) != c ){
        			return sb.toString();
        		}
        	}
        	sb.append(c);
        }

        return sb.toString();
    }
}


// Solution 2 --- 分治递归divide and conquer的方法来解决。
// 时间复杂度: 考虑worst case, 假设字符串平均k长度，一共n个字符串，且假设这些字符串都一样。则divide and conquer首先类似
//            merge sort的过程，一共分了logn层，但是这题的分治递归的复杂度求解不太一样，因为最下面一层一共n个string, 看做
//            n/2组，他们一共比较了k次，所以应该是k * n/2, 同理再上一层，就是k * n/4, 再上一层就是 k * n/8, 直到最后一层
//            所以复杂度仍然也是O(k * n)

// 空间复杂度: 递归深度消耗的系统栈为O(logn)

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ){
        	return "";
        }
        int length = strs.length;
        // assume不会有空字符串
        return divideAndConquer(strs, 0, length - 1);

    }

    private String divideAndConquer(String[] strs, int left, int right){
    	if( left == right ){
    		return strs[left];
    	}
    	int middle = left + ((right-left) >> 1);

    	String leftRes = divideAndConquer(strs, left, middle);
    	String rightRes = divideAndConquer(strs, middle+1, right);
    	return common(leftRes, rightRes);
    }

    private String common(String s1, String s2){

    	StringBuilder sb = new StringBuilder();
    	int length = Math.min(s1.length(), s2.length());
    	for(int i = 0; i < length; i++){
    		char c1 = s1.charAt(i);
    		char c2 = s2.charAt(i);
    		if( c1 == c2 ){
    			sb.append(c1);
    		}else{
    			break;
    		}
    	}
    	return sb.toString();
    }
}
