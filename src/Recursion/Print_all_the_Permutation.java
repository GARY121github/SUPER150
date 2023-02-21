package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Print_all_the_Permutation {
    public static void main(String[] args) {
        String st = "AAB";
        List<String> list = new ArrayList<>();
        printPermutation(st , "" , list);
        System.out.println(list);
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

    static void printPermutation(String st , String ans , List<String> list){
        if(st.length() == 0){
            list.add(ans);
            return;
        }

        for(int i = 0 ; i < st.length() ; i++){
            boolean flag = false;
            for(int j = 0 ; j < ans.length() ; j++){
                if(ans.charAt(j) == st.charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            String prefix = st.substring(0 , i);
            String postfix = st.substring(i+1);
            printPermutation(prefix + postfix , ans + st.charAt(i) , list);
        }
    }
}
