class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int totalSum = 0;
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++){
            totalSum += nums[r];
            while (totalSum >= target){
                if (r - l + 1 < minLength){
                    minLength = r - l + 1;
                }
                totalSum -= nums[l];
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}