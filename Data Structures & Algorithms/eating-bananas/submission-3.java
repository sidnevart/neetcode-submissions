class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int pile : piles){
            r = Math.max(r, pile);
        }
        r++;

        int l = 1;
        while (l < r){
            int speedOfEating = l + (r - l) / 2;
            if (isEnough(speedOfEating, h, piles)){
                r = speedOfEating;
            } else {
                l = speedOfEating + 1;
            }
        }
        return l;
    }

    public boolean isEnough(int speed, int h, int [] piles){
        int hours = 0;
        for (int pile : piles){
            hours += Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}
