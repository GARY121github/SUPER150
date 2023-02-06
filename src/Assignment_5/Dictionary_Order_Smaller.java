package Assignment_5;

import java.util.Scanner;

/*

Take as input str, a string. Write a recursive function which returns all the words possible by rearranging the
characters of this string which are in dictionary order smaller than the given string. The output strings must be
lexicographically sorted.

Input Format
Single line input containing a string

Constraints
Length of string <= 10

All characters are unique

Output Format
Display all the words which are in dictionary order smaller than the string entered in a new line each.
The output strings must be sorted.

Sample Input
cab
Sample Output
abc
acb
bac
bca
Explanation
The possible permutations of string "cab" are "abc" , "acb" ,"bac" , "bca" , "cab" and "cba" .
Only four of them are lexicographically less than "cab". We print them in lexicographical order.

*/
public class Dictionary_Order_Smaller {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String st = sc.next();
            int[] frequency = new int[255];
            for (int i = 0 ; i < st.length() ; i++){
                frequency[st.charAt(i)]++;
            }
            lexicoGraphically(frequency , st , "");
        }
        static void lexicoGraphically(int[] arr , String st, String ans){

            if(ans.compareTo(st) >= 0){
                return;
            }

            if(ans.length() == st.length()){
                System.out.println(ans);
            }

            for (int i = 0 ; i < 255 ; i++){
                if(arr[i] != 0){
                    arr[i]--;
                    lexicoGraphically(arr , st , ans+((char) (i)));
                    arr[i]++;
                }
            }
        }


}
