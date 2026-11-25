class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        char[] string = s.toCharArray();
        int longest = 0;
        int l = 0;
        for (int r = 0; r < string.length; r++){
            while (seen.contains(string[r])){
                seen.remove(string[l]);
                l++;
            } 
            seen.add(string[r]);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
