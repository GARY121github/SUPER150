package Assignment_8;

import java.util.Scanner;

/*
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the
order of the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after
removal of elements C, E and F.

Given two strings A and B of size n and m respectively, you have to find the length of Longest Common Subsequence(LCS)
of strings A and B, where LCS is the longest sequence present in both A and B.

Input Format
Two strings A and B.

Constraints
1 <= n,m <= 10^3

Output Format
Output the LCS of A and B.

Sample Input
abc
acd
Sample Output
2
*/
public class Length_of_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int[] a : dp){
        //     Arrays.fill(a , -1);
        // }
        // return lcs(text1 , text1.length() - 1 , text2 , text2.length() - 1 , dp);
        System.out.println(tabulation(text1 , text2));
    }
    private static int lcs(String s1 , int i , String s2 , int j , int[][] dp){
        if(i == -1 || j == -1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = lcs(s1 , i-1 , s2 , j-1 , dp) + 1;
        }
        else{
            // choose from s1
            int f1 = lcs(s1 , i-1 , s2 , j , dp);

            // choose from s2
            int f2 = lcs(s1 , i , s2 , j-1 , dp);

            ans = Math.max(f1 , f2);
        }

        return dp[i][j] = ans;
    }

    private static int tabulation(String s1 , String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                int ans = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    ans = dp[i-1][j-1] + 1;
                }
                else{
                    int f1 = dp[i-1][j];
                    int f2 = dp[i][j-1];
                    ans = Math.max(f1 , f2);
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
