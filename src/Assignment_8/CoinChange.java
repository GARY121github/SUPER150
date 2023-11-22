package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
valued coins, In how many ways can we make the change? The order of coins doesn’t matter.

Input Format
First line of input contain two space separated integers N and M. Second line of input contains M space separated
integers - value of coins.

Constraints
1<=N<=250
1<=m<=50
1 <= Si <= 50

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
public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0 ; i < n ; i++){
            coins[i] = sc.nextInt();
        }
//        int[][] dp = new int[target+1][n];
//        for (int[] arr : dp){
//            Arrays.fill(arr , -1);
//        }
//        System.out.println(memoization(coins , target , coins.length - 1 ,dp));

        System.out.println(tabulation(coins , target));
    }

    private static int memoization(int[] coins , int target , int index , int[][] dp){
        if(target == 0){
            return 1;
        }

        if(index == -1){
            return 0;
        }

        if(dp[target][index] != -1){
            return dp[target][index];
        }

        int choose = 0;

        if(coins[index] <= target){
            choose = memoization(coins , target - coins[index] , index , dp);
        }

        int not_choose = memoization(coins , target , index - 1 , dp);

        return dp[target][index] = choose + not_choose;
    }

    private static int tabulation(int[] coins , int target){
        int[][] dp = new int[target + 1][coins.length + 1];

//        target == 0
        Arrays.fill(dp[0] , 1);

        for (int i = 1 ; i < dp.length ; i++){
            for (int j = 1 ; j < dp[0].length ; j++){

                int choose = 0;
                if(coins[j - 1] <= i){
//                    choose = memoization(coins , target - coins[index] , index , dp);

                    choose = dp[i - coins[j-1]][j];
                }

//                int not_choose = memoization(coins , target , index - 1 , dp);

                int not_choose = dp[i][j-1];

                dp[i][j] = choose + not_choose;
            }
        }

        for (int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
