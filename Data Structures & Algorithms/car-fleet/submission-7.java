class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Integer> stack = new Stack<>();
        int [][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // [4,2] [1, 3]
        for (int i = 0; i < cars.length; i++){
            double timeToTarget = (double) (target - cars[i][0]) / cars[i][1];
            if (!stack.isEmpty()){
                double curTimeToTarget = (double) (target - cars[stack.peek()][0]) / cars[stack.peek()][1];
                if (curTimeToTarget < timeToTarget){
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }

        return stack.size();
    }
}
