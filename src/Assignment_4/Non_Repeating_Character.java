package Assignment_4;
/*

Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”,
then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.

Input Format
The first line contains T denoting the number of testcases. Then follows description of testcases.
Each case begins with a single integer N denoting the length of string. The next line contains the string S.

Constraints
Output Format
For each testcase, print the first non repeating character present in string. Print -1 if there is no non repeating character.

Sample Input
3
codingblocks
abbac
java
Sample Output
d
c
j

*/

import java.util.Scanner;

public class Non_Repeating_Character {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String st = sc.next();
            nonRepeating(st);
        }
    }

    static void nonRepeating(String s){
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(arr[ch - 'a'] == 1){
                System.out.println(ch);
                return;
            }
        }

        System.out.println(-1);
    }
}
