package Assignment_3;

/*

Take as input S, a string. Write a function that replaces every even character with the character having just higher ASCII code
and every odd character with the character having just lower ASCII code. Print the value returned.

Input Format
String

Constraints
Length of string should be between 1 to 1000.

Output Format
String

Sample Input
abcg
Sample Output
badf

*/

import java.util.Scanner;

public class Strings_Odd_Even_Character {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        for(int i = 0 ; i < st.length() ; i++){
            if(i%2 == 0){
                System.out.print((char) (st.charAt(i) + 1));
            }
            else{
                System.out.print((char) (st.charAt(i) - 1));
            }
        }
    }
}
