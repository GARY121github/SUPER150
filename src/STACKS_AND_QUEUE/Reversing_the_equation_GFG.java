package STACKS_AND_QUEUE;

import java.util.Stack;

public class Reversing_the_equation_GFG {
    public static void main(String[] args) {

    }
    String reverseEqn(String s)
    {
        Stack<String> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*' || ch == '+' || ch == '/' || ch == '-'){
                stack.push(num.toString());
                num = new StringBuilder();
                stack.push("" + ch);
            }
            else{
                num.append(ch);
            }
        }

        while(!stack.isEmpty()){
            num.append(stack.pop());
        }

        return num.toString();
    }
}
