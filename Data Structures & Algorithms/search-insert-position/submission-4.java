class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length - 1;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int mid = l + (r-l)/2;
            if (target > nums[mid]){
                ans = mid + 1;
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans < 0 ? 0 : ans;
    }
}