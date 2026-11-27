class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        // 1 2 4 6
        // 6 4 2 1
        Stack<Double> carTimeToTarget = new Stack<>();
        for (int i = 0; i < cars.length; i++){
            double timeToTarget = (double) (target - cars[i][0]) / cars[i][1];
            if (carTimeToTarget.isEmpty()){
                carTimeToTarget.push(timeToTarget);
            } else if (carTimeToTarget.peek() < timeToTarget){
                carTimeToTarget.push(timeToTarget);
            }
        }

        return carTimeToTarget.size();
    }
}
