package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.

Input Format
First line contains first string . Second line contains second string. Third line contains the third string.

Constraints
The length of all strings is |s|< 200

Output Format
Output an integer denoting the length of longest common subsequence of above three strings.

Sample Input
GHQWNV
SJNSDGH
CPGMAH
Sample Output
2
Explanation
"GH" is the longest common subsequence
*/
public class LCS_with_3_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        for(int[][] arr : dp){
            for(int[] a : arr){
                Arrays.fill(a , -1);
            }
        }
        System.out.println(lcs(s1 , 0 , s2 , 0 , s3 , 0 , dp));
    }
    private static int lcs(String s1 , int i , String s2 , int j , String s3 , int k , int[][][] dp){
        if(i == s1.length() || j == s2.length() || k == s3.length()){
            return 0;
        }

        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            ans = lcs(s1 , i+1 , s2 , j+1 , s3 , k+1 , dp) + 1;
        }
        else{
            // choose from s1
            int f1 = lcs(s1 , i+1 , s2 , j , s3 , k , dp);

            // choose from s2
            int f2 = lcs(s1 , i , s2 , j+1 , s3 , k , dp);

            // choose from s3
            int f3 = lcs(s1 , i , s2 , j , s3 , k+1 , dp);

            ans = Math.max(f1 , Math.max(f2 , f3));
        }
        return dp[i][j][k] = ans;
    }
}
