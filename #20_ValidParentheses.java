// Solution 1 --- 利用括号的就近对称性，每出现一个右括号就要去看是否有其对应的最近左括号与其匹配。
// 				  注意特殊情况比如只有左括号，或者右括号比左括号先出现。总之完全匹配后，判断完后堆栈要位空。
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public boolean isValid(String s) {
        if( s == null || s.length() == 0 ){
        	return false;
        }
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < length; i++){
        	char c = s.charAt(i);
        	if( c == '(' || c == '[' || c == '{' ){
        		stack.push(c);
        	}else{
        		if( stack.empty() ){
        			return false;
        		}
        		if( c == ')' && stack.peek() != '(' ){
        			return false;
        		}

        		if( c == ']' && stack.peek() != '[' ){
        			return false;
        		}

        		if( c == '}' && stack.peek() != '{' ){
        			return false;
        		}
        		stack.pop();
        	}
        }
        if( !stack.empty() ){
        	return false;
        }
        return true;
    }
}
