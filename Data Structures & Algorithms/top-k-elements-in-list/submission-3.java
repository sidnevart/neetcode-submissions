class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a,b) -> Integer.compare(b[0], a[0]));

        int [] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
/*
0 1 2 3 4 5
1 2 2 3 3 3 






*/