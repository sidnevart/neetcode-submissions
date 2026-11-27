class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int aboveIdx = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int leftIdx = stack.peek();
                int w = i - leftIdx - 1;
                int h = Math.min(height[leftIdx], height[i]) - height[aboveIdx];
                water += h * w;
            }
            stack.push(i);
        }
        return water;
    }
}
