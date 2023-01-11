package Recursion;

public class Find_all_the_possible_subsequence {
    public static void main(String[] args) {
        print_subsequence("abc" , "");
    }

    static void print_subsequence(String s , String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }

        print_subsequence(s.substring(1 ) , ans);
        print_subsequence(s.substring( 1) , ans+s.charAt(0));

    }
}
