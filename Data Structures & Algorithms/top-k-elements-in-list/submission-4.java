class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        int [] res = new int[k];
        int idx = 0;
        while(!minHeap.isEmpty()){
            res[idx] = minHeap.poll()[1];
            idx++;
        }

        return res;
    }
}
/*
0 1 2 3 4 5
1 2 2 3 3 3 






*/