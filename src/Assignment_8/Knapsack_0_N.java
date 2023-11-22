package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
You've heard of 0-1 knapsack. Below is the problem statement for the same.

Given weights and values of n items, put these items in a knapsack of capacity cap to get the maximum total value in the
knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated
with n items respectively. Also given an integer cap which represents knapsack capacity, find out the maximum value subset
of val[] such that sum of the weights of this subset is smaller than or equal to cap. You cannot break an item, either pick
the complete item, or don’t pick it (0-1 property).
There is a little twist for 0-N knapsack. You can pick an element more than once. Now you have to find maximum value multi
subset of val[] such that sum of the weights of this subset is smaller than or equal to cap.

Note: Maximum value subset means the sunset with maximum sum of all the values in subset.

Input Format
The first line contains two integers, representing n(size of val[]) and cap respectively. The subsequent line contains n
integers representing the wt[] array. The next line, again, contains n integers representing the val[] array.

Constraints
1 <= n,cap <= 1000 1 <= wt[i] <= cap 1 <= val[i] <= 100000

Output Format
Print a single integer, the answer to the problem.

Sample Input
5 11
3 2 4 5 1
4 3 5 6 1
Sample Output
16
Explanation
We take second item 4 times and fifth item one time to make the total values 16.
*/
public class Knapsack_0_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0 ; i < arr.length ; i++){
            arr[i][0] = sc.nextInt();
        }
        for (int i = 0 ; i < arr.length ; i++){
            arr[i][1] = sc.nextInt();
        }
//        int[][] dp = new int[capacity+1][arr.length];
//        System.out.println(knapsack_0_N(arr , capacity , arr.length - 1 , dp));
        System.out.println(tabulation(arr , capacity));
    }
    private static int knapsack_0_N(int[][] arr , int capacity , int index , int[][] dp){
        if(capacity == 0 || index == -1){
            return 0;
        }

        if(dp[capacity][index] != 0){
            return dp[capacity][index];
        }
//        CHOOSE
        int choose = 0;
        if(arr[index][0] <= capacity){
            choose = arr[index][1] + knapsack_0_N(arr , capacity - arr[index][0] , index , dp);
        }

        int not_choose = knapsack_0_N(arr , capacity , index - 1 , dp);

        return dp[capacity][index] = Math.max(choose , not_choose);
    }

    private static int tabulation(int[][] arr , int capacity){
        int[][] dp = new int[capacity+1][arr.length+1];

        for (int i = 1 ; i < dp.length ; i++){
            for (int j = 1 ; j < dp[0].length ; j++){
                int choose = 0;
                if(arr[j-1][0] <= i){
                    choose = arr[j-1][1] + dp[i - arr[j-1][0]][j];
                }

                int not_choose = dp[i][j-1];

                dp[i][j] = Math.max(choose , not_choose);
            }
        }

        return dp[dp.length-1][dp[0].length - 1];
    }
}
