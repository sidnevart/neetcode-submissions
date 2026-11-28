class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int longest = 0;
        Deque<Integer> maxDeq = new ArrayDeque<>(); // decr
        Deque<Integer> minDeq = new ArrayDeque<>(); // incr
        int l = 0;
        for (int r = 0; r < nums.length; r++){
            while (!maxDeq.isEmpty() && nums[maxDeq.peekLast()] < nums[r]){
                maxDeq.pollLast();
            }
            maxDeq.offerLast(r);

            while (!minDeq.isEmpty() && nums[minDeq.peekLast()] > nums[r]){
                minDeq.pollLast();
            }
            minDeq.offerLast(r);

            while (nums[maxDeq.peekFirst()] - nums[minDeq.peekFirst()] > limit){
                if (maxDeq.peekFirst() == l){
                    maxDeq.pollFirst();
                }
                if (minDeq.peekFirst() == l){
                    minDeq.pollFirst();
                }
                l++;
            }

            longest = Math.max(r - l + 1, longest);

        }
        return longest;
    }
}