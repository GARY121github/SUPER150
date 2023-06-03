package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Outermost_Parentheses_GFG {
    public static void main(String[] args) {
        String s = "(()())(())";
    }
    public static String removeOuter(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(stack.size() > 0){
                    ans.append(ch);
                }
                stack.push(ch);
            }
            else{
                if(stack.size() > 1){
                    ans.append(ch);
                }
                stack.pop();
            }
        }
        return ans.toString();
    }
}
