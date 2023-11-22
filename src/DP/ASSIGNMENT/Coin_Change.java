package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
In how many ways can we make the change? The order of coins doesn’t matter.

Input Format
First line of input contain two space separated integers N and M. Second line of input contains M space separated integers - value of
coins.

Constraints
1<=N<=250 1<=m<=50 1 <= Si <= 50

Output Format
Output a single integer denoting the number of ways to make the given change using given coin denominations.

Sample Input
10 4
2 5 3 6
Sample Output
5
Explanation
2 2 2 2 2
2 2 3 3
2 2 6
2 3 5
5 5

Total 5 ways
*/
public class Coin_Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

//        System.out.println(totalWays(arr , target , 0));
        int[][] dp = new int[target+1][arr.length+1];
        for (int[] a : dp){
            Arrays.fill(a , -1);
        }

//        System.out.println(totalWaysTD(arr , target , 0 , dp));
        System.out.println(totalWaysBU(arr , target));
    }

    private static int totalWays(int[] arr , int target , int index){
        if(target == 0){
            return 1;
        }
        if(index == arr.length || target < 0){
            return 0;
        }

        int choose , not_choose;
        choose = not_choose = 0;

        choose = totalWays(arr , target-arr[index] , index);
        not_choose = totalWays(arr , target , index+1);

        return choose + not_choose;
    }

    private static int totalWaysTD(int[] arr , int target , int index , int[][] dp){
        if(target == 0){
            return 1;
        }
        if(index == arr.length || target < 0){
            return 0;
        }

        if(dp[target][index] != -1){
            return dp[target][index];
        }

        int choose , not_choose;
        choose = not_choose = 0;

        choose = totalWaysTD(arr , target-arr[index] , index , dp);
        not_choose = totalWaysTD(arr , target , index+1 , dp);

        return dp[target][index] = choose + not_choose;
    }

    private static int totalWaysBU(int[] arr , int target){
        int[][] dp = new int[target+1][arr.length+1];
        Arrays.fill(dp[0] , 1);

        for(int i = 1 ; i <= target ; i++){
            for(int j = 1 ; j <= arr.length ; j++){
                int choose , not_choose;
                choose = 0;

                if(arr[j-1] <= i){
                    choose = dp[i - arr[j-1]][j];
                }

                not_choose = dp[i][j-1];

                dp[i][j] = choose + not_choose;
            }
        }

        return dp[target][arr.length];
    }
}
