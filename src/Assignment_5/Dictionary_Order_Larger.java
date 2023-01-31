package Assignment_5;

/*
Take as input str, a string. Write a recursive function which prints all the words possible by rearranging the
characters of this string which are in dictionary order larger than the given string.
The output strings must be lexicographically sorted.

Input Format
Single line input containing a string

Constraints
Length of string <= 10

All characters are unique

Output Format
Display all the words which are in dictionary order larger than the string entered in a new line each.
The output strings must be sorted.

Sample Input
cab

Sample Output
cba
Explanation
The possible permutations of string "cab" are "abc" , "acb" ,"bac" , "bca" , "cab" and "cba" .
Only one of them is lexicographically greater than "cab". We only print "cba".
*/

import java.util.Scanner;

public class Dictionary_Order_Larger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int[] frequency = new int[26];
        for (int i = 0 ; i < st.length() ; i++){
            frequency[st.charAt(i) - 97]++;
        }
        lexicoGraphically(frequency , st , "");
    }
    static void lexicoGraphically(int[] arr , String st, String ans){

        if(ans.length() == st.length()){
            if(ans.compareTo(st) <= 0){
                return;
            }
            System.out.println(ans);
            return;
        }

        for (int i = 0 ; i < 26 ; i++){
            if(arr[i] != 0){
                arr[i]--;
                lexicoGraphically(arr , st , ans+((char) (i+97)));
                arr[i]++;
            }
        }
    }
}
