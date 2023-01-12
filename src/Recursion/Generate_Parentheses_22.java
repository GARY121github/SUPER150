package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate_Parentheses_22 {
    public static void main(String[] args) {

    }

    static List<String> generateParenthesis(int n , int open , int close , String ans) {
        ArrayList<String> list = new ArrayList<>();
        if(open == n && close == n){
            list.add(ans);
            return list;
        }

        if(open < n){
            list.addAll(generateParenthesis(n , open+1, close , ans+'('));
        }

        if(close < n && close < open){
            list.addAll(generateParenthesis(n , open , close+1 , ans + ')'));
        }

        return list;
    }
}
