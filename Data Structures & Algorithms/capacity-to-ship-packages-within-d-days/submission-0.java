class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxPossibleCap = 0;
        int sumUpCap = 0;
        for (int weight : weights){
            maxPossibleCap = Math.max(weight, maxPossibleCap);
            sumUpCap += weight;
        }

        int l = maxPossibleCap;
        int r = sumUpCap;
        int ans = maxPossibleCap;

        while (l <= r){
            int m = l + (r - l) / 2;
            if (canShip(weights, days, m)){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
    /*
    [1,5,4,4,2,3]
    c = 7
    w, tw, d
    1, 1, 0
    5, 6, 0
    4, 10, 1 => tw = 4
    4, 8, 2 => tw = 4
    2, 6, 2
    3, 9, 3 => tw = 3

    */
    public boolean canShip(int[] weights, int days, int capacity){
        int daysTaken = 1;
        int totalWeight = 0;
        for (int weight : weights){
            if (totalWeight + weight > capacity){
                daysTaken += 1;
                totalWeight = 0;
            }

            totalWeight += weight;

        }

        return daysTaken <= days;
    }
}