class Solution {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();

        StringBuilder curString = new StringBuilder();
        int curNum = 0;

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                curNum = curNum * 10 + (c - '0');
            } else if (c == '[') {
                numbers.push(curNum);
                strings.push(curString);

                curNum = 0;
                curString = new StringBuilder();
            } else if (c == ']') {
                int repeat = numbers.pop();
                StringBuilder prefix = strings.pop();

                for (int i = 0; i < repeat; i++) {
                    prefix.append(curString);
                }

                curString = prefix;
            } else {
                curString.append(c);
            }
        }

        return curString.toString();
    }
}