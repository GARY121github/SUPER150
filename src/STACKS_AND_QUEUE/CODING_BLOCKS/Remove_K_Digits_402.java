package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Remove_K_Digits_402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
    }
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0 ; i < num.length() ; i++){
                char ch = num.charAt(i);

                while (k > 0 && !stack.isEmpty() && ch < stack.peek()){
                    stack.pop();
                    k--;
                }

                stack.push(ch);
            }

            while (k > 0){
                stack.pop();
                k--;
            }

            char[] arr = new char[stack.size()];
            for(int i = stack.size()-1 ; i >= 0 ; i--){
                arr[i] = stack.pop();
            }

            int p = 0;
            while (p < arr.length && arr[p] == '0')
                p++;

            StringBuilder ans = new StringBuilder();
            for(int i = p ; i < arr.length ; i++){
                ans.append(arr[i]);
            }


            return ans.toString();
        }
    }
}
