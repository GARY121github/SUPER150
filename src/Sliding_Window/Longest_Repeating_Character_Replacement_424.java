package Sliding_Window;

import java.util.Arrays;

public class Longest_Repeating_Character_Replacement_424 {
    public static void main(String[] args) {
        String st = "AAAA";
        int k = 2;
        System.out.println(characterReplacement(st , k));
    }
    static int characterReplacement(String st, int k){
        int[] frequency = frequency(st);
        int max = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(frequency[i] > 0){
                int t = max_after_flipping_other_character(st , k , (char) (i+65));
                if(t > max){
                    max = t;
                }
            }
        }

        return max;

    }

    static int max_after_flipping_other_character(String st , int k , char ch){
        int s = 0;
        int e = 0;
        int flip = 0;
        int max = 0;
        while (e < st.length()){
            char c = st.charAt(e);
//            GROW
            if(c != ch){
                flip++;
            }

//            SHRINK
            while (flip > k){
                char rem = st.charAt(s);
                if(rem != ch){
                    flip--;
                }

                s++;
            }

//            WINDOW
            max = Math.max(max , e-s+1);

            e++;
        }
        return max;
    }

    static int[] frequency(String st){
        int[] arr = new int[26];
        for(int i = 0 ; i < st.length() ; i++){
            arr[st.charAt(i)-65]++;
        }
        return arr;
    }
}
