package DP;

import java.util.Arrays;

public class Longest_common_subsequence_1143 {
    public static void main(String[] args) {
//        Input: text1 = "abcde", text2 = "ace"
//        Output: 3
//        Explanation: The longest common subsequence is "ace" and its length is 3.

        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp){
            Arrays.fill(arr , -1);
        }
    }

    private static int LCS(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + LCS(s1, s2, i + 1, j + 1);
        } else {
            int rfs1 = LCS(s1, s2, i + 1, j);
            int rfs2 = LCS(s1, s2, i, j + 1);

            ans = Math.max(rfs1, rfs2);
        }
        return ans;
    }

    private static int LCS_Memoization(String s1, String s2, int i, int j , int[][] dp){
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + LCS_Memoization(s1, s2, i + 1, j + 1 , dp);
        } else {
            int rfs1 = LCS_Memoization(s1, s2, i + 1, j , dp);
            int rfs2 = LCS_Memoization(s1, s2, i, j + 1 , dp);

            ans = Math.max(rfs1, rfs2);
        }
        return dp[i][j] = ans;
    }
}
