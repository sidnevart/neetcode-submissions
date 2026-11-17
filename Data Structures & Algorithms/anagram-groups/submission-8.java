class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs){
            int [] cnt = new int[26];
            for (char c : word.toCharArray()){
                cnt[c - 'a']++;
            }
            String key = Arrays.toString(cnt);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}
