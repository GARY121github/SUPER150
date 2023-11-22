package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is
not).

Input Format
Input number of test cases The first argument of input contains a string, A. The second argument of input contains a string, B.

Constraints
1<=T<=100
1 <= length(A), length(B) <= 100

Output Format
Return an integer representing the answer as described in the problem statement.

Sample Input
1
rabbbit
rabbit
Sample Output
3
Explanation
These are the possible removals of characters:
    => A = "ra_bbit"
    => A = "rab_bit"
    => A = "rabb_it"
*/
public class Distinct_Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            String s1 = sc.next();
            String s2 = sc.next();
            int[][] dp = new int[s1.length()][s2.length()];
           
            for (int[] arr : dp){
                Arrays.fill(arr , -1);
            }
            System.out.println(permute(s1 , 0 , s2 , 0 , dp));
        }
    }

    private static int permute(String s1 , int i , String s2 , int j , int[][] dp){
        if(j == s2.length()){
            return 1;
        }

        if(i == s1.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int choose , not_choose;
        choose = not_choose = 0;

        if(s1.charAt(i) == s2.charAt(j)){
            choose = permute(s1 , i+1 , s2 , j+1 , dp);
        }

        not_choose = permute(s1 , i+1 , s2 , j , dp);

        return dp[i][j] = choose + not_choose;
    }
}
