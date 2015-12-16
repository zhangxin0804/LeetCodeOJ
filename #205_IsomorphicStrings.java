// Solution 1 --- 利用两个HashMap分别保存t map to s的关系和s map to t的关系, 注意corner case
//                双HashMap存储映射关系！！！

// 时间复杂度: O(n)
// 空间复杂度: O(n)

// corner case:
// foo <- bar, ab<-aa, aa<-ab, ab<-ca

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // assume s and t are not null and not empty, also same length
        int length = s.length();
        HashMap<Character, Character> map1 = new HashMap<Character, Character>(); // s to t
        HashMap<Character, Character> map2 = new HashMap<Character, Character>(); // t to s
        for(int i = 0; i < length; i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if( map1.containsKey(s1) ){
                if( map1.get(s1) != t1 ){
                    return false;
                }
            }else{
                if( map2.containsKey(t1) ){
                    if( map2.get(t1) != s1 ){
                        return false;
                    }
                }else{
                    map1.put(s1, t1);
                    map2.put(t1, s1);
                }
            }
        }
        return true;
    }
}
