class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int cur = nums[0];
        for (int right = 1; right < nums.length; right++){
            if (nums[right] != cur){
                cur = nums[right];
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return left;
    }
}