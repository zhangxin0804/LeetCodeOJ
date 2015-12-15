
// Solution 1 -- 利用两个堆栈stack, 倒来倒去，画图理解实现Queue.
// 时间复杂度: pop()和peek()的平均复杂度都是O(1)
// 空间复杂度: O(n)

class MyQueue {
    
    Stack<Integer> stack1 = new Stack<Integer>(); // 入队栈
    Stack<Integer> stack2 = new Stack<Integer>(); // 出队栈
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }
    // Removes the element from in front of queue.
    public void pop() {
        if( !stack2.empty() ){
            stack2.pop();
        }else{
            while( !stack1.empty() ){
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
    }
    // Get the front element.
    public int peek() {
        if( !stack2.empty() ){
            return stack2.peek();
        }
        while( !stack1.empty() ){
            stack2.push(stack1.pop());
        }   
        return stack2.peek();
    }
    // Return whether the queue is empty.
    public boolean empty() {
        if( stack1.empty() && stack2.empty() ){
            return true;
        }
        return false;
    }
}
