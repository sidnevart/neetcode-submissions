class Solution {
    public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int result = 0;
        prefixSum.put(0, 1);

        for (int num : nums){
            curSum += num;
            int diff = curSum - k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0 ) + 1);
        }
        return result;
    }
}