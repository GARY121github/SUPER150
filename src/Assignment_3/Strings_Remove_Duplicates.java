package Assignment_3;

/*

Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.

Input Format
String

Constraints
A string of length between 1 to 1000

Output Format
String

Sample Input
aabccba
Sample Output
abcba
Explanation
For the given example, "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.

After removing all of the consecutive occurences, the Final ans will be : - "abcba".

*/

import java.util.Scanner;

public class Strings_Remove_Duplicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        removeDuplicates(st);
        // Your Code Here
    }
    static void removeDuplicates(String st){
        int p1 = 0;
        int p2 = 0;
        // int count = 0;
        while(p2 < st.length()){
            if(st.charAt(p1) != st.charAt(p2)){
                System.out.print(st.charAt(p1));
                // System.out.print(count);

                // count = 0;
                p1 = p2;
            }
            else{
                p2++;
                // count++;
            }
        }
        // count = 0;
        for(int i = p1 ; i < st.length() ; i++){
            if(st.charAt(p1) == st.charAt(i)){
                // count++;
            }
        }
        System.out.print(st.charAt(p1));
        // System.out.print(count);
    }
}
