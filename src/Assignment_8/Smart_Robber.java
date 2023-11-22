package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
A professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping him from robbing each of them is that adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
of money he can rob tonight without alerting the police.

Input Format
First line contains integer t as number of testcases. Second line contains integer n as size of array. Third line
contains a single integer as element of array.

Constraints
None

Output Format
Print the maximum money as output.

Sample Input
1
4
1 2 3 1
Sample Output
4

*/
public class Smart_Robber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < arr.length ; i++){
                arr[i] = sc.nextInt();
            }
//            int[] dp = new int[n];
//            System.out.println(memoization(0, arr, dp));
            System.out.println(tabulation(arr));
        }
    }

    private static int memoization(int i, int[] arr, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int choose = memoization(i + 2, arr, dp) + arr[i];
        int not_choose = memoization(i + 1, arr, dp);

        return dp[i] = Math.max(choose , not_choose);
    }

    private static int tabulation(int[] arr){
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        dp[1] = arr[1];

        for (int i = 2 ; i < arr.length ; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + arr[i]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[arr.length-1];
    }
}
