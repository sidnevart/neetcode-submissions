class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int [] windowsMax = new int[nums.length - k + 1];
        int l = 0;
        for (int r = 0; r < nums.length; r++){
            while (!deque.isEmpty() && deque.peekLast() < nums[r]){
                deque.pollLast();
            }
            deque.offerLast(nums[r]);
            if (r - l + 1== k){
                windowsMax[l] = deque.peekFirst();
                if (deque.peekFirst() == nums[l]){
                    deque.pollFirst();
                }
                l++;
            }
        }

        return windowsMax;
    }
}
