class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> [] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int idx = 0;
        for (int i = freq.length - 1; i > 0 && idx < k; i--){
            for (int num : freq[i]){
                result[idx] = num;
                idx++;
                if (idx == k){
                    return result;
                }
            }
        }

        return result;
    }
}

/*
0  1   2   3 4 5 6
  [1] [2] [3]

*/
