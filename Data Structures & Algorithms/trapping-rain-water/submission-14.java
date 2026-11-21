class Solution {
    static class Trap {
        private int index;
        private int height;

        public Trap(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    public int trap(int[] height) {
        int water = 0;
        Stack<Trap> stack = new Stack<>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] >= stack.peek().height){
                Trap rightWall = stack.pop();
                if (stack.isEmpty()){
                    break;
                }

                Trap leftWall = stack.peek();
                int w = i - leftWall.index - 1;
                int h = Math.min(leftWall.height, height[i]) - rightWall.height;
                water += w * h; 
            }
            stack.push(new Trap(i, height[i]));
        }

        return water;
    }
}
