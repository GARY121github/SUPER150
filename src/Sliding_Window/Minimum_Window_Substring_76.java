package Sliding_Window;

public class Minimum_Window_Substring_76 {
    public static void main(String[] args) {

    }
    static String minWindow(String st, String t) {
        int[] frequency = new int[123];
        for(int i = 0 ; i < t.length() ; i++){
            frequency[t.charAt(i)]++;
        }

        int s = 0;
        int e = 0;
        int start = -1;
        int end = -1;
        int count = 0;
        int MIN = Integer.MAX_VALUE;
        int[] arr = new int[123];
        while (e < st.length()){
//            GROW
            arr[st.charAt(e)]++;

            if(arr[st.charAt(e)] <= frequency[st.charAt(e)]){
                count++;
            }

            if(count == t.length()){
                while (arr[st.charAt(s)] > frequency[st.charAt(s)]){
                    arr[st.charAt(s)]--;
                    s++;
                }

                int current = e-s+1;
                if(current < MIN){
                    MIN = current;
                    start = s;
                    end = e;
                }


            }

            e++;
        }

        return st.substring(start , end+1);
    }
}
