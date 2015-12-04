// Solution 1 -- 根据Anagram字符串的定义，即字符及其字符个数都一样，仅仅是字符排列的order不同。
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)

public class Solution {
    public boolean isAnagram(String s, String t) {
        
        // assume s and t are not null and not empty
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if( sArr.length != tArr.length ){
        	return false;
        }
        for(int i = 0; i < sArr.length; i++){
        	if( sArr[i] != tArr[i] ){
        		return false;
        	}
        }
        return true;
    }
}


// Solution 2 -- 利用HashMap来统计字符出现频次，然后在检测目标字符串中的字符并更新次数，相当于抵消的概念，最后HashMap的size为0即true.
// 时间复杂度: O(n)
// 空间复杂度: O(n), 如果字符只有可能是扩展ASCII码中的256个，则为O(1)

public class Solution {
    public boolean isAnagram(String s, String t) {
        // assume s and t are not null and not empty
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if( map.containsKey(c) ){
        		map.put(c, map.get(c) + 1);
        	}else{
        		map.put(c,1);
        	}
        }  

        for(int j = 0; j < t.length(); j++){
        	char c = t.charAt(j);
        	if( !map.containsKey(c) ){
        		return false;
        	}else{
        		map.put(c, map.get(c) - 1);
        		if( map.get(c) == 0 ){
        			map.remove(c);
        		}
        	}
        } 	
        if( map.size() != 0 ){
        	return false;
        }
        return true;
    }
}
