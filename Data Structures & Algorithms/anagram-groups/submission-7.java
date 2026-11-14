class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs){
            int [] cnt = new int[26];
            for (char c : str.toCharArray()){
                cnt[c - 'a']++;
            }
            String key = Arrays.toString(cnt);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
