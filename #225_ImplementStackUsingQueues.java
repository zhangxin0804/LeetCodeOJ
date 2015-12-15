
// Solution 1 --- 利用队列是双端的性质，可以形成一个rotate array来模拟Stack, 同时维护top变量。
// 时间复杂度: pop()的时间复杂度是O(n), top()的时间复杂度是O(1)
// 空间复杂度: O(n)

class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    int top;
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int n = queue.size() - 1;
        while( n-- > 0 ){
            int tmp = queue.poll();
            queue.add(tmp);
            top = tmp;
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if( queue.isEmpty() ){
            return true;
        }   
        return false;
    }
}

