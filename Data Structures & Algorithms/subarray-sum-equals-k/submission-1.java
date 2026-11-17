class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        freq.put(0, 1);

        for (int num : nums){
            prefix += num;
            int diff = prefix - k;
            res += freq.getOrDefault(diff, 0);
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}