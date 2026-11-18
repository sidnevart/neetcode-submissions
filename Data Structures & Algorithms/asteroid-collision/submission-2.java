class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++){
            boolean alive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0){
                if (stack.peek() == Math.abs(asteroids[i])){
                    alive = false;
                    stack.pop();
                    break;
                } else if (stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                } else {
                    alive = false;
                    break;
                }
            }
            if (alive){
                stack.push(asteroids[i]);
            }
        }

        int n = stack.size();
        int [] ans = new int[n];
        for (int i = n - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }
}