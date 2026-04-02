class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") 
            || tokens[i].equals("*") || tokens[i].equals("/")){
                if(!stack.isEmpty()){
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    if(tokens[i].equals("+")) res = val2 + val1;
                    else if(tokens[i].equals("-")) res = val2 - val1;
                    else if(tokens[i].equals("*")) res = val2 * val1;
                    else if(tokens[i].equals("/")) res = val2 / val1;
                    
                    stack.push(res);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
