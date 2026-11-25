class Solution {
    public String minWindow(String s, String t) {
        int[] cnt_s = new int[128];
        int[] cnt_t = new int[128];

        for (char c : t.toCharArray()) {
            cnt_t[c]++;
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {
            char char_r = s.charAt(r);
            cnt_s[char_r]++;

            while (checkPresence(cnt_s, cnt_t)) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char char_l = s.charAt(l);
                cnt_s[char_l]--;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + minLen);
    }

    public boolean checkPresence(int[] cnt_s, int[] cnt_t) {
        for (int i = 0; i < 128; i++) {
            if (cnt_s[i] < cnt_t[i]) {
                return false;
            }
        }

        return true;
    }
}