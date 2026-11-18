class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int [] ans = new int[n];
        stack.push(0);
        for (int i = 1; i < n; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int lastIdx = stack.peek();                
                stack.pop();
                ans[lastIdx] = i - lastIdx;
            }
            stack.push(i);
        }

        return ans;
    }
}
