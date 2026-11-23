class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int right = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int h = Math.min(height[left], height[i]) - height[right];
                int w = i - left - 1;
                water += w * h;
            }
            stack.push(i);
        }
        return water;
    }
}
