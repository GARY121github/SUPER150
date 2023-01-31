package Assignment_5;

import java.util.ArrayList;
import java.util.Scanner;

/*
Take as input str, a string. str represents keys pressed on a nokia phone keypad.
We are concerned with all possible words that can be written with the pressed keys.

Assume the following alphabets on the keys: 1 -> abc , 2 -> def , 3 -> ghi , 4 -> jkl , 5 -> mno , 6 -> pqrs ,
7 -> tuv , 8 -> wx , 9 -> yz

E.g. “12” can produce following words “ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”

a.Write a recursive function which returns the count of words for a given keypad string. Print the value returned.
b.Write a recursive function which prints all possible words for a given keypad string (void is the return type for
function).

Input Format
Single line input containing a single integer.

Constraints
1 <= Length of string <= 10^3

Output Format
Print all the words in a space separated manner. Also print the count of these numbers in next line.

Sample Input
12
Sample Output
ad ae af bd be bf cd ce cf
9
Explanation
1 can correspond to 'a' , 'b' or 'c' .
2 can correspond to 'd', 'e' or 'f'.
We print all combinations of these
*/
public class Recursion_Keypad_Codes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        ArrayList<String> list = letterCombinations(st , "");
        for (String i : list){
            System.out.print(i + ' ');
        }
        System.out.println();
        System.out.println(list.size());
    }
//    1 -> abc , 2 -> def , 3 -> ghi , 4 -> jkl , 5 -> mno , 6 -> pqrs ,
//            7 -> tuv , 8 -> wx , 9 -> yz
    static String[] digits = {"" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wx" , "yz"};

    static ArrayList<String> letterCombinations(String st , String ans){
        ArrayList<String> list = new ArrayList<>();
        if(st.isEmpty()){
            list.add(ans);
            return list;
        }

        for (int i = 0; i < digits[st.charAt(0) - 48].length() ; i++){
            list.addAll(letterCombinations(st.substring(1) , ans+digits[st.charAt(0) - 48].charAt(i)));
        }

        return list;
    }

}
