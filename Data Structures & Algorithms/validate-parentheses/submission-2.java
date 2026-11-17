class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char openingBracket = stack.pop();
                if (c != map.get(openingBracket)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
