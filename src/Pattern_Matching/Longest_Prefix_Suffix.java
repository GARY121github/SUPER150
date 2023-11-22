package Pattern_Matching;

// 1392. Longest Happy Prefix

public class Longest_Prefix_Suffix {
    public static void main(String[] args) {
        String st = "aabaadfaabaa";
        System.out.println(lps(st));
    }
    private static String lps(String st){
        int[] arr = new int[st.length()];
        int len = 0;
        int i = 1;
        while (i < st.length()){
            if(st.charAt(i) == st.charAt(len)){
                len++;
                arr[i] = len;
                i++;
            }
            else{
                if(len > 0){
                    len = arr[len-1];
                }
                else{
                    arr[i] = 0;
                    len = 0;
                    i++;
                }
            }
        }
        return st.substring(0 , arr[st.length()-1]);
    }
}
