package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S (1 <= S <= 1000).
You also have N (1<= N <= 1000) items that you might want to take with you to the sea side. Unfortunately you can not fit all of them
in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of
all the items you are going to bring. What is this maximum total value?

Input Format
On the first line you are given N and S.
Second line contains N space separated integer where ith integer denotes the size of ith item. Third line contains N space seperated
integers where ith integer denotes the value of ith item.

Constraints
1 <= S,N <= 1000

Output Format
Output a single integer showing the maximum value that can be obtained by optimally choosing the items.

Sample Input
5 4
1 2 3 2 2
8 4 0 5 3
Sample Output
13
Explanation
Total capacity = 4.
Pick size 1 with value 8 and size 2 with value 5.
*/
public class O_1_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0 ; i < n ; i++){
            wt[i] = sc.nextInt();
        }
        for (int i = 0 ; i < n ; i++){
            val[i] = sc.nextInt();
        }

        int[][] dp = new int[cap+1][n+1];
        for (int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        System.out.println(KnapsackTD(wt , val , 0 , cap , dp));
        System.out.println(Knapsack(wt , val , cap));
    }

    private static int KnapsackTD(int[] wt , int[] val , int index , int cap , int[][] dp){
        if(index == wt.length || cap == 0){
            return 0;
        }

        if(dp[cap][index] != -1){
            return dp[cap][index];
        }

        int inc = 0;
        int exc = 0;

        if(wt[index] <= cap){
            inc = KnapsackTD(wt , val , index+1 , cap-wt[index] , dp) + val[index];
        }

        exc = KnapsackTD(wt , val , index+1 , cap , dp);

        return dp[cap][index] = Math.max(inc , exc);
    }

    private static int Knapsack(int[] wt , int[] val , int cap){
        int[][] dp = new int[cap+1][val.length+1];

        for(int i = 1 ; i <= cap ; i++){
            for(int j = 1 ; j <= wt.length ; j++){
                int inc , exc;
                inc = exc = 0;
                if(wt[j-1] <= i){
                    inc = dp[i-1][j] + val[j-1];
                }
                exc = dp[i][j-1];

                dp[i][j] = Math.max(inc , exc);
            }
        }

        for (int[] arr : dp){
            for (int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return dp[cap][wt.length];
    }
}
