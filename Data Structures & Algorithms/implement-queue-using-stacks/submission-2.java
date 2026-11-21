class MyQueue {

    Stack<Integer> resultStack;
    Stack<Integer> poppedStack;
    int peekNum = 0;

    public MyQueue() {
        resultStack = new Stack<>();
        poppedStack = new Stack<>();
    }
    
    public void push(int x) {
        resultStack.push(x);
    }
    
    public int pop() {
        if (poppedStack.isEmpty()){
            while (!resultStack.isEmpty()){
                poppedStack.push(resultStack.pop());
            }
        }
        return poppedStack.pop();
    }
    
    public int peek() {
        if (poppedStack.isEmpty()){
            while (!resultStack.isEmpty()){
                poppedStack.push(resultStack.pop());
            }
        }
        return poppedStack.peek();
    }
    
    public boolean empty() {
        return resultStack.isEmpty() && poppedStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */