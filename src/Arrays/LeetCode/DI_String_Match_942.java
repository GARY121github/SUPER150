package Arrays.LeetCode;

import java.util.Stack;

public class DI_String_Match_942 {
    public static void main(String[] args) {

    }

    static int[] diStringMatch(String s) {
        // int N = s.length();
        // int lo = 0, hi = N;
        // int[] ans = new int[N + 1];
        // for (int i = 0; i < N; ++i) {
        //     if (s.charAt(i) == 'I')
        //         ans[i] = lo++;
        //     else
        //         ans[i] = hi--;
        // }

        // ans[N] = lo;
        // return ans;

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
}
