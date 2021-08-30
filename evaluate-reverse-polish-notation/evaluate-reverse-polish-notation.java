class Solution {
    public void operand(Stack<Integer> stack, String token){
        int num1 = stack.pop();
        int num2 = stack.pop();
        int result = 0;
        
        if(token.equals("+")){
            result = num1 + num2;
        }
        else if(token.equals("-")){
            result = num2 - num1;
        }
        else if(token.equals("*")){
            result = num2 * num1;
        }
        else if(token.equals("/")){
            result = num2 / num1;
        }
        
        stack.push(result);

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                operand(stack, token);
            }
            else{
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        
        int answer = stack.pop();
        
        return answer;
    }
}