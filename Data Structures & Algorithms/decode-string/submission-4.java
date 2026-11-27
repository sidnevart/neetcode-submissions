class Solution {
    public String decodeString(String s) {
        String curString = "";
        String curNum = "";
        Stack<String> stackN = new Stack<>();
        Stack<String> stackS = new Stack<>();
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                curNum += c;
            } else if (c == '['){
                stackS.push(curString);
                stackN.push(curNum);
                curNum = "";
                curString = "";
            } else if (c == ']'){
                curString = stackS.pop() + curString.repeat(Integer.parseInt(stackN.pop()));
            } else {
                curString += c;
            }
        }

        return curString;
    }
}