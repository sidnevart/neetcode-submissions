class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        int k = s1.length();
        int l = 0;
        int [] cnt_s1 = new int[26];
        int [] cnt_s2 = new int[26];

        for (char c: s1.toCharArray()){
            cnt_s1[c - 'a']++;
        }
        for (int r = 0; r < s2.length(); r++){
            char char_r = s2.charAt(r);
            cnt_s2[char_r - 'a']++;

            if (r - l + 1 == s1.length()){
                if (Arrays.equals(cnt_s2, cnt_s1)){
                    return true;
                }
                char char_l = s2.charAt(l);
                cnt_s2[char_l - 'a']--;
                l++;
            }
        }

        return false;
    }
}
