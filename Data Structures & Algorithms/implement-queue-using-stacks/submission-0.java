class MyQueue {

    Stack<Integer> resultStack;
    Stack<Integer> poppedStack;
    int peekNum = 0;

    public MyQueue() {
        resultStack = new Stack<>();
        poppedStack = new Stack<>();
    }
    
    public void push(int x) {
        if (resultStack.isEmpty()){
            peekNum = x;
        }
        resultStack.push(x);
    }
    
    public int pop() {
        while (!resultStack.isEmpty()){
            poppedStack.push(resultStack.pop());
        }

        int poppedItem = poppedStack.pop();
        if (poppedStack.isEmpty()){
            peekNum = poppedItem;
        } else {
            peekNum = poppedStack.peek();
        }

        while(!poppedStack.isEmpty()){
            resultStack.push(poppedStack.pop());
        }

        return poppedItem;
    }
    
    public int peek() {
        return peekNum;
    }
    
    public boolean empty() {
        return resultStack.isEmpty();
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