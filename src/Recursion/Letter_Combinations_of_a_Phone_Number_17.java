package Recursion;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Letter_Combinations_of_a_Phone_Number_17 {

    public static void main(String[] args) {

    }

    static String[] text = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static List<String> letterCombinations(String digits , String ans) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            list.add(ans);
            return list;
        }

        for(int i = 0 ; i < text[digits.charAt(0) - 48].length() ; i++){
            list.addAll(letterCombinations(digits.substring(1), ans+ text[digits.charAt(0) - 48].charAt(i)));
        }

        return list;
    }
}
