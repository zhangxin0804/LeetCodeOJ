
// Solution 1 --- 逆波兰表示法也即后缀表达式求值，用堆栈来解决, 注意除数可能为0的情况，注意多考虑一下+ *时的溢出情况
// 时间复杂度: O(n)
// 空间复杂度: O(n)

public class Solution {
    public int evalRPN(String[] tokens) {
        // assume tokens are valid
        int length = tokens.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < length; i++){
            if( tokens[i].equals("+") ){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left+right);
            }else if( tokens[i].equals("-") ){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left-right);                
            }else if( tokens[i].equals("*") ){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left*right);                
            }else if( tokens[i].equals("/") ){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left/right);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
