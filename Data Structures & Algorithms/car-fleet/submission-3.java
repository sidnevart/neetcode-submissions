class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 1;
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++){
            cars.add(new int[]{position[i], speed[i]});
        }

        cars.sort((a, b) -> Integer.compare(b[0], a[0]));

        double prevTime = (double) (target - cars.get(0)[0]) / cars.get(0)[1];

        for (int i = 1; i < cars.size(); i++){
            double curTime = (double) (target - cars.get(i)[0]) / cars.get(i)[1];
            if (curTime > prevTime){
                fleets++;
                prevTime = curTime;
            }
        }

        return fleets;

    }
}
