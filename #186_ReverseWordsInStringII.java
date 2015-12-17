// Solution 1 --- 三步翻转法！！先把每一个word进行in-place的swap, 然后在swap整体。别忘了最后一个word的SWAP
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public void reverseWords(char[] s) {
        if( s == null || s.length == 0 ){
            return;
        }
        int length = s.length;
        int start = 0, end = 0;
        for( end = 0; end < length; end++){
            if( s[end] == ' '){
                swap(s, start, end-1);
                start = end+1;
            }
        }
        //别忘了最后一个word的swap
        swap(s, start, end-1);
        //再整体swap
        swap(s, 0, length - 1);
    }
    private void swap(char[] s, int i, int j){
        while( i <= j ){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
