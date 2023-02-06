package Recursion;

import java.util.ArrayList;

public class Breakdown_Strings_in_all_possible_way {
    public static void main(String[] args) {
        String st = "NITIN";
//        subString(st , new ArrayList<>());
        subString(st , "");
    }

//    static void subString(String st , ArrayList<String> list){
//        if(st.isEmpty()){
//            System.out.println(list);
//            return;
//        }
//
//        for (int i = 1 ; i <= st.length() ; i++){
//            String sub = st.substring(i);
//            list.add(String.valueOf(st.substring(0 , i)));
//            subString(sub , list);
//            list.remove(list.size()-1);
//        }
//    }

    static void subString(String s , String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }

        for (int i = 1 ; i <= s.length() ; i++){
            String sub = s.substring(i);
            subString(sub , ans+s.substring(0 , i) + " ");
        }
    }
}
