
// Solution 1 --- 利用两个堆栈来实现，其中一个辅助堆栈用于维护一个单调递减栈，从而保证O(1)时间得到最小值
//                这题如果改成实现Max Stack, 做法是一样的
// 时间复杂度: O(1)
// 空间复杂度: O(n)

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> helpStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if( helpStack.empty() || x <= helpStack.peek() ){
        	helpStack.push(x);
        }
    }
    public void pop() {
        if( stack.empty() ){
        	return;
        }
        if( stack.peek().equals(helpStack.peek()) ){
        	helpStack.pop();
        }
        stack.pop();
    }
    public int top() {
     	if( stack.empty() ){
     		return -1;
     	}
     	return stack.peek();
    }
    public int getMin() {
        if( helpStack.empty() ){
        	return -1;
        }
        return helpStack.peek();
    }
}
