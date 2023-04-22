package Arrays.LeetCode;

import java.util.Stack;

public class DI_String_Match_942 {
    public static void main(String[] args) {

    }

    static int[] diStringMatchThroughStacks(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length() + 1];
        int count = 0;

        for(int i = 0 ; i <= s.length() ; i++){
            if(i == s.length() || s.charAt(i) == 'I'){
                arr[i] = count;
                count++;
                while(!stack.isEmpty()){

                    arr[stack.pop()] = count++;

                }
            }
            else{
                stack.push(i);
            }
        }
        return arr;
    }

    static int[] diStringMatchThroughLoops(String pattern){
        int[] arr = new int[pattern.length() + 1];
        int count = 1;
        for(int i = 0 ; i <= pattern.length() ; i++){
            if( i == pattern.length() || pattern.charAt(i) == 'I'){
                arr[i] = count;
                count++;
                for(int j = i-1 ; j >= 0 && pattern.charAt(j) != 'I' ; j--){
                    arr[j] = count;
                    count++;
                }
            }
        }

        return arr;
    }
}
