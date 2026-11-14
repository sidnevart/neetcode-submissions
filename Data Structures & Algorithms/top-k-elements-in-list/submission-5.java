class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int [] res = new int[k];
        int idx = 0;
        for(int i = freq.length - 1; i > 0 && idx < k; i--){
            for (int num : freq[i]){
                res[idx] = num;
                idx++;
                if (idx ==k){
                    return res;
                }
            }
        }

        return res;
    }
}
/*
0 1 2 3 4 5
1 2 2 3 3 3 






*/