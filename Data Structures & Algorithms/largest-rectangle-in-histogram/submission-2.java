class Solution {
    static class Rectangle{
        int height;
        int index;
        public Rectangle(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Rectangle> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]){
                Rectangle rec = stack.pop();
                int idx = rec.index;
                int h = rec.height;
                int w = i - idx;
                maxArea = Math.max(w * h, maxArea);
                start = idx;
            }
            stack.push(new Rectangle(heights[i], start));
        }

        for (Rectangle rec : stack){
            int w = heights.length - rec.index;
            int h = rec.height;
            maxArea = Math.max(w * h, maxArea);
        }
        return maxArea;
    }
}
