class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int cur = nums[0];
        for (int r = 1; r < nums.length; r++){
            if (nums[r] != cur){
                cur = nums[r];
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
        }
        return l;
    }
}