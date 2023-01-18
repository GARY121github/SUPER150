package Recursion;

public class Print_all_the_Permutation {
    public static void main(String[] args) {
        Tricky_printPermutation("abca" , "");
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

    static void Tricky_printPermutation(String st , String ans){
        if(st.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i < st.length() ; i++){
            boolean flag = true;
            for(int j = i+1 ; j < st.length() ; j++){
                if(st.charAt(i) == st.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                String prefix = st.substring(0 , i);
                String postfix = st.substring(i+1);
                Tricky_printPermutation(prefix + postfix , ans + st.charAt(i));
            }
        }
    }
}
