package DP.ASSIGNMENT;

import java.util.Scanner;

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Input Format
Two strings

Constraints
None

Output Format
Single integer output

Sample Input
horse ros
Sample Output
3
Explanation
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/
public class CodeWars_2_0_Edit_Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(minDistance(s1 , s2));

    }
    public static int minDistance(String word1, String word2) {

        return edit(word1 , word2 , 0 , 0);
    }
    private static int edit(String s1 , String s2 , int i , int j){
        if(i == s1.length()){
            return s2.length() - j;
        }
        if(j == s2.length()){
            return s1.length() - i;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return edit(s1 , s2 , i+1 , j+1);
        }
        else{
            // INSERT A CHARACTER
            int f1 = edit(s1 , s2 , i , j+1);

            // DELETE A CHARACTER
            int f2 = edit(s1 , s2 , i+1 , j);

            // REPLACE A CHARACTER
            int f3 = edit(s1 , s2 , i+1 , j+1);

            return Math.min(f1 , Math.min(f2 , f3)) + 1;
        }
    }
}
