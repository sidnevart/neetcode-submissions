class Solution {
    static class Rectangle {
        private int height;
        private int index;

        public Rectangle(int height, int index){
            this.index = index;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Rectangle> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]){
                Rectangle rec = stack.pop();
                maxArea = Math.max(maxArea, (i - rec.index) * rec.height);
                start = rec.index;
            }
            stack.push(new Rectangle(heights[i], start));
        }

        for (Rectangle rec : stack){
            maxArea = Math.max(maxArea, rec.height * (heights.length - rec.index));
        }

        return maxArea;
    }
}
