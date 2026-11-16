class Solution {
    public boolean validPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            while (left < right && !Character.isLetterOrDigit(lChar)){
                left++;
                lChar = s.charAt(left);
            }

            while (left < right && !Character.isLetterOrDigit(rChar)){
                right--;
                rChar = s.charAt(right);
            }

            if (lChar != rChar){

                return isValidPalindrome(s.substring(left + 1, right + 1)) || isValidPalindrome(s.substring(left, right));
            } else {
                left++;
                right--;
            }
        }

        return true;
    }


    public boolean isValidPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            while (left < right && !Character.isLetterOrDigit(lChar)){
                left++;
                lChar = s.charAt(left);
            }

            while (left < right && !Character.isLetterOrDigit(rChar)){
                right--;
                rChar = s.charAt(right);
            }

            if (lChar != rChar){
                return false;
            } 
            left++;
            right--;
        }

        return true;
    }
}