class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // array of freq
        // freq map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> [] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int [] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i > 0 && idx < k; i--){
            for (int num : freq[i]){
                res[idx++] = num;
            }
        }

        return res;
    }
}
