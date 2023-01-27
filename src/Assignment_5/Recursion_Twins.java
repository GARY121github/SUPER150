package Assignment_5;

import java.util.Scanner;

/*

Take an input str, a string. A “twin” is defined as two instances of a char separated by a char.
E.g. "AxA" the A's make a “twin”. “twins” can overlap, so "AxAxA" contains 3 “twins” - 2 for A and 1 for x.
Write a function which recursively counts number of “twins” in a string. Print the value returned.

Input Format
Enter the string

Constraints
None

Output Format
Display the number of twins

Sample Input
AXAXA
Sample Output
3

*/
public class Recursion_Twins {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        output(str, 0);
    }
    public static void output(String str, int count) {
        if(str.length()==2) {
            System.out.println(count);
            return;
        }
        char ch1=str.charAt(0);
        char ch2=str.charAt(2);
        String ros=str.substring(1);
        if(ch1==ch2) {
            count++;
        }
        output(ros,count);
    }
}
