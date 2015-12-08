

// Solution 1 ------ two pointers同向前冲双指针，sliding window + HashMap, 维护maxLength, 注意如何收缩window左边界。
// 注意：/****/之间的代码，也就是关键的window左边界如何收缩。比如abcdefgd...., d出现后新的左边界应该从e开始，于是就是
// efgd.....a, 如果此时又出现a, map仍然会检测a在其中，但是a的位置是 < 当前left的，属于窗口外的字符，所以我们不对其处理，而是更新其
// 位置即可。即此时a在map的位置得到更新。

// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if( s == null || s.length() == 0 ){
            return 0;
        }
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = Integer.MIN_VALUE;
        int left = 0, right = 0;
        for( right = 0; right < length; right++){
            char c = s.charAt(right);
            if( map.containsKey(c) ){
                /********************************/
                if( map.get(c) >= left ){
                    maxLength = Math.max(maxLength, right - left);
                    left = map.get(c) + 1;
                }
                map.put(c, right);
                /********************************/
            }else{
                map.put(c, right);
            }
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}

// Solution 0 ---- 暴力Brute force方法，枚举每个字符为起始，然后遍历后序字符串，利用HashSet检测重复，然后维护maxLength
//                 不是最优解！！！！
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if( s == null || s.length() == 0 ){
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<Character>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            set.add(s.charAt(i));
            for(int j = i + 1; j < length; j++){
                char c = s.charAt(j);
                if( set.contains(c) ){
                    break;
                }else{
                    set.add(c);
                }
            }
            maxLength = Math.max(maxLength, set.size());
            set.clear();
        }
        return maxLength;
    }
}
