
// Solution 2 --- 既然是找10个字符的子串，用一个sliding window来截取所有可能的子串，然后用HashSet判断是否出现多次。还要再用一个
//                HashSet来避免重复添加子串进解集。

// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if( s == null || s.length() == 0 ){
            return res;
        }
        int length = s.length();
        HashSet<String> hash = new HashSet<String>();
        HashSet<String> resHash = new HashSet<String>();
        int left = 0, right = 0;
        for( right = left + 10 - 1; right < length; right++ ){
        	String tmp = s.substring(left, right+1);
        	if( hash.contains(tmp) ){
        		if( resHash.contains(tmp) ){
        			continue;
        		}
        		res.add(tmp);
        		resHash.add(tmp);
        	}else{
        		hash.add(tmp);
        	}
        	left++;
        }
        return res;
    }
}


// Solution 1 ---- brute force暴力解法, 每次选择基准字符串，然后去匹配所有可能相等的子串，匹配到就加入解集，最后用HashSet记录
//                 已经检测过的基准子串，避免不必要的检测。 Not AC, TLE.
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if( s == null || s.length() == 0 ){
            return res;
        }
        int length = s.length();
        // hash存储检测过的10-letter-long的序列
        HashSet<String> hash = new HashSet<String>();
        for(int i = 0; i < length - 10 + 1; i++){
            // 选择基准子串
            String base = s.substring(i, i+10);
            if( hash.contains(base) ){
                continue;
            }
            // 寻找匹配子串
            for(int j = i+1; j + 10 < length - 1; j++){
                if( s.substring(j, j + 10).equals(base) ){
                    res.add(base);
                    break;
                }
            }
            hash.add(base);
        }
        return res;
    }
}
