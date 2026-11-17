class MinStack {
    List<Integer> minimums;
    Stack<Integer> stack;
    public MinStack() {
        minimums = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minimums.size() == 0){
            minimums.add(val);
        } else {
            int curMin = Math.min(val, minimums.get(minimums.size() - 1));
            minimums.add(curMin);
        }
    }
    
    public void pop() {
        minimums.remove(minimums.size() - 1);
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimums.get(minimums.size() - 1);
    }
}
