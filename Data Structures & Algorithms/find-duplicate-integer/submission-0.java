class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length - 1;

        int firstIntersect = 0;
        int slow2nd = 0;
        while (true){
            int next = nums[slow];
            slow = next;
            next = nums[fast];
            next = nums[next];
            fast = next;

            if (slow == fast){
                firstIntersect = slow;
                slow2nd = 0;
                break;
            }
        }


        while (slow != slow2nd) {
            slow = nums[slow];
            slow2nd = nums[slow2nd];
        }

        return slow;
    }
}
