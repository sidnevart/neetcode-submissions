class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (!token.equals("+") && !token.equals("/") && !token.equals("*") && !token.equals("-")){
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                if (token.equals("+")){
                    res = b + a;
                } else if (token.equals("/")){
                    res = b / a;
                } else if(token.equals("-")){
                    res = b - a;
                } else {
                    res = b * a;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
