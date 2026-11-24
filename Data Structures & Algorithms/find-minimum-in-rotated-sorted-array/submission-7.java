class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= r){
            if (nums[l] <= nums[r]){
                ans = Math.min(nums[l], ans);
            }

            int m = l + (r-l)/2;
            ans = Math.min(ans, nums[m]);
            if (nums[l] <= nums[m]){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }
}
