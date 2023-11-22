package DP.Longest_Common_Subsequence_LCS;

public class Edit_Distance_72 {
    private int tabulation(String st1, String st2) {
        int[][] dp = new int[st1.length() + 1][st2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= st1.length(); i++) {
            for (int j = 1; j <= st2.length(); j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // INSERT A CHARACTER
                    // int f1 = edit(s1 , s2 , i , j+1);
                    int f1 = dp[i][j - 1];

                    // DELETE A CHARACTER
                    // int f2 = edit(s1 , s2 , i+1 , j);
                    int f2 = dp[i - 1][j];

                    // REPLACE A CHARACTER
                    // int f3 = edit(s1 , s2 , i+1 , j+1);
                    int f3 = dp[i - 1][j - 1];


                    dp[i][j] = Math.min(f1, Math.min(f2, f3)) + 1;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
