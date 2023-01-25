package Sliding_Window;

import java.util.Arrays;

public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        String s ="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    static int lengthOfLongestSubstring(String st) {
        int[] arr = new int[123];
        int s = 0;
        int e = 0;
        int max = 0;
        while (e < st.length()){
//            GROW
            arr[st.charAt(e)]++;

//            SHRINK
            while (arr[st.charAt(e)] > 1){
                arr[st.charAt(s)]--;
                s++;
            }
//            System.out.println(Arrays.toString(arr));
            System.out.println(st.substring(s , e+1));
            max = Integer.max(max , e-s+1);
            e++;

        }
        return max;
    }
}
