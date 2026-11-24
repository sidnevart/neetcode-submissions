class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int weight : weights){
            l = Math.max(l, weight);
            r += weight;
        }
        int ans = 0;

        while (l <= r){
            int m = l + (r - l) / 2;
            if (canShip(weights, days, m)){
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }


    public boolean canShip(int [] weights, int days, int cap){
        int totalWeight = 0;
        int daysTaken = 1;

        for (int weight : weights){
            if (totalWeight + weight > cap){
                daysTaken++;
                totalWeight = 0;
            }
            totalWeight += weight;
        }

        return daysTaken <= days;
    }
}