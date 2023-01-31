package Assignment_5;

import java.util.ArrayList;
import java.util.Scanner;

/*
Take as input str, a string. We are concerned with all the possible subsequences of str. E.g.

a. Write a recursive function which returns the count of subsequences for a given string. Print the value returned.

b. Write a recursive function which prints all possible subsequences for a “abcd” has following subsequences
“”, “d”, “c”, “cd”, “b”, “bd”, “bc”, “bcd”, “a”, “ad”, “ac”, “acd”, “ab”, “abd”, “abc”, “abcd”.given string
(void is the return type for function).
Note: Use cin for input for C++

Input Format
Enter a string

Constraints
None

Output Format
Print all the subsequences in a space separated manner and isplay the total no. of subsequences.

Sample Input
abcd
Sample Output
 d c cd b bd bc bcd a ad ac acd ab abd abc abcd
16
Explanation
Print all possible subsequences of the given string.
*/
public class Recursion_Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        ArrayList<String> list = subSequence(st , "");
        for (String s : list){
            System.out.print(s + ' ');
        }
        System.out.println();
        System.out.println(list.size());
    }

    static ArrayList<String> subSequence(String st , String ans){
        ArrayList<String> list = new ArrayList<>();
        if(st.isEmpty()){
            list.add(ans);
            return list;
        }

        list.addAll(subSequence(st.substring(1) , ans));
        list.addAll(subSequence(st.substring(1) , ans+st.charAt(0)));

        return list;
    }
}
