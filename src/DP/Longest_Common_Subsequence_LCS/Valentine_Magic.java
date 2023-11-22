package DP.Longest_Common_Subsequence_LCS;

import java.util.Arrays;
import java.util.Scanner;

// https://codeskiller.codingblocks.com/problems/281
public class Valentine_Magic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] boys = new int[n];
        int[] girls = new int[m];
        for (int i = 0; i < n; i++) {
            boys[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            girls[j] = sc.nextInt();
        }

        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        Arrays.sort(boys);
        Arrays.sort(girls);

        System.out.println(valentineMagic(boys, 0, girls, 0, dp));

        for (int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(tabulation(boys , girls));
    }

    private static int valentineMagic(int[] boys, int i, int[] girls, int j, int[][] dp) {
        if (i == boys.length) {
            return 0;
        }
        if (j == girls.length) {
            return 1000000;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int choose = Math.abs(boys[i] - girls[j]) + valentineMagic(boys, i + 1, girls, j + 1, dp);
        int notChoose = valentineMagic(boys, i, girls, j + 1, dp);

        return dp[i][j] = Math.min(choose, notChoose);
    }

    private static int tabulation(int[] boys, int[] girls) {
        int[][] dp = new int[boys.length + 1][girls.length + 1];
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 1000000;
        }

        Arrays.sort(boys);
        Arrays.sort(girls);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int choose = Math.abs(boys[i - 1] - girls[j - 1]) + dp[i - 1][j - 1];
                int not_choose = dp[i][j - 1];

                dp[i][j] = Math.min(choose, not_choose);
            }
        }

        for (int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
