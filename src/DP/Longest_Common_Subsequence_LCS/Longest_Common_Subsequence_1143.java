package DP.Longest_Common_Subsequence_LCS;

import java.util.Arrays;

public class Longest_Common_Subsequence_1143 {
    public static void main(String[] args) {
        String st1 = "abcde";
        String st2 = "ace";
//        System.out.println(longestCommonSubsequenceRecursion(st1, 0, st2, 0));
        int[][] dp = new int[st1.length()][st2.length()];

//        System.out.println(memoization(st1, 0, st2, 0, dp));
        System.out.println(tabulation(st1 , st2));
    }
    private static int longestCommonSubsequenceRecursion(String st1, int i, String st2, int j) {
        if (i == st1.length() || j == st2.length()) {
            return 0;
        }


        if (st1.charAt(i) == st2.charAt(j)) {
            return longestCommonSubsequenceRecursion(st1, i + 1, st2, j + 1) + 1;
        } else {

//            CHOOSE FROM st1
            int chooseFromst1 = longestCommonSubsequenceRecursion(st1, i + 1, st2, j);

//            CHOOSE FROM st2
            int chooseFromst2 = longestCommonSubsequenceRecursion(st1, i, st2, j + 1);

            return Math.max(chooseFromst1, chooseFromst2);
        }
    }

    private static int memoization(String st1, int i, String st2, int j, int[][] dp) {
        if (i == st1.length() || j == st2.length()) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = 0;
        if (st1.charAt(i) == st2.charAt(j)) {
            ans = 1 + memoization(st1, i + 1, st2, j + 1, dp);
        } else {

            int chooseFromSt1 = memoization(st1, i + 1, st2, j, dp);
            int chooseFronSt2 = memoization(st1, i, st2, j + 1, dp);

            ans = Math.max(chooseFromSt1, chooseFronSt2);
        }

        return dp[i][j] = ans;
    }

    private static int tabulation(String st1, String st2) {
        int[][] dp = new int[st1.length() + 1][st2.length() + 1];
        for (int i = 1; i <= st1.length(); i++) {
            for (int j = 1; j <= st2.length(); j++) {
                if(st1.charAt(i-1) == st2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    int chooseFromSt1 = dp[i-1][j];
                    int chooseFromSt2 = dp[i][j-1];

                    dp[i][j] = Math.max(chooseFromSt1 , chooseFromSt2);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
