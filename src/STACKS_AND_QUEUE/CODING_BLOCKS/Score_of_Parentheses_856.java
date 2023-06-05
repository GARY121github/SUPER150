package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Score_of_Parentheses_856 {
    public static void main(String[] args) {

    }
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                // TREAT -INFINITY AS OPENING BRACKET
                stack.push(Integer.MIN_VALUE);
            }
            else{
                int sum = 0;
                while(stack.peek() != Integer.MIN_VALUE){
                    sum += stack.pop();
                }
                stack.pop();

                int value = Math.max(sum*2 , 1);
                stack.push(value);
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
