package DP.Longest_Common_Subsequence_LCS;

public class Uncrossed_Lines_1035 {

    private static int tabulation(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int chooseFrom_arr1 = dp[i - 1][j];
                    int chooseFrom_arr2 = dp[i][j - 1];

                    dp[i][j] = Math.max(chooseFrom_arr1, chooseFrom_arr2);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
