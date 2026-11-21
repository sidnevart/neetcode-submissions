class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] w_maxes = new int[nums.length - k + 1];
        int l = 0;
        for (int r = 0; r < nums.length; r++){
            while (!queue.isEmpty() && queue.peekLast() < nums[r]){
                queue.pollLast();
            }

            queue.offerLast(nums[r]);

            if (r - l + 1 == k){
                w_maxes[l] = queue.peekFirst();
                if(nums[l] == queue.peekFirst()){
                    queue.pollFirst();
                }
                l++;
            }
        }

        return w_maxes;
    }
}
