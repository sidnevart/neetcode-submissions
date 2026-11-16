class Solution {
    public boolean isPalindrome(String s) {
        String string = s.toLowerCase().replaceAll("\\s+", "");
        int left = 0;
        int right = string.length() - 1;

        while (left < right){
            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);
            while (left < right && !Character.isLetterOrDigit(leftChar)){
                left++;
                leftChar = string.charAt(left);
            }

            while (left < right && !Character.isLetterOrDigit(rightChar)){
                right--;
                rightChar = string.charAt(right);
            }

            if (rightChar != leftChar){
                return false;
            } else {
                left++;
                right--;
            }


        } 

        return true;
    }
}
/*
"tab a cat"




*/