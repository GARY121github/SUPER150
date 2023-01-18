package Recursion;

public class Print_all_the_Permutation {
    public static void main(String[] args) {
        printPermutation("abc" , "");
    }

    static void printPermutation(String st , String ans){
        if(st.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i < st.length() ; i++){
            String prefix = st.substring(0 , i);
            String postfix = st.substring(i+1);
            printPermutation(prefix + postfix , ans + st.charAt(i));
        }
    }
}
