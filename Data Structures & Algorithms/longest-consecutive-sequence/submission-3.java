class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int longest = 0;
        for (int num : set){
            int curLongetivity = 1;
            if (!set.contains(num - 1)){
                while (set.contains(num+1)){
                    num++;
                    curLongetivity++;
                    longest = Math.max(curLongetivity, longest);
                }
            }
            longest = Math.max(curLongetivity, longest);
        }
        return longest;
    }
}

