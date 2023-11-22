package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
You are packing for a vacation on the seaside, and you are going to carry only one bag with capacity S (1 <= S <= 1000).
You also have N (1<= N <= 1000) items that you might want to take with you to the seaside. Unfortunately you can not fit
all of them in the knapsack, so you will have to choose. For each item you are given its size and its value. You want to
maximize the total value of all the items you are going to bring. What is this maximum total value?

Input Format
On the first line you are given N and S.
Second line contains N space separated integer where ith integer denotes the size of ith item. Third line contains N space
separated integers where ith integer denotes the value of ith item.

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
public class Knapsack_0_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i][0] = sc.nextInt();
        }

        for (int i = 0 ; i < arr.length ; i++){
            arr[i][1] = sc.nextInt();
        }

//        int[][] dp = new int[n][capacity+1];
//        System.out.println(knapsack_0_1(arr , 0 , capacity , dp));
        System.out.println(tabulation(arr , capacity));
    }
    private static int knapsack_0_1(int[][] arr , int index , int capacity , int[][] dp){
        if(capacity == 0 || index == -1){
            return 0;
        }

        if(dp[index][capacity] != 0){
            return dp[index][capacity];
        }

        //        choose
        int choose = 0;
        if(arr[index][0] <= capacity){
            choose = arr[index][1] + knapsack_0_1(arr , index - 1 , capacity - arr[index][0] , dp);
        }

        //        not choose
        int not_choose = knapsack_0_1(arr , index - 1 , capacity , dp);

        return dp[index][capacity] = Math.max(choose , not_choose);
    }

    private static int tabulation(int[][] arr , int capacity){
        int[][] dp = new int[capacity+1][arr.length];

        for(int i = 1 ; i < dp.length ; i++){
            for (int j = 1 ; j < dp[0].length ; j++){
                int choose = 0;
                if(arr[j-1][0] <= i){
                    choose = arr[j-1][1] + dp[i - arr[j-1][0]][j - 1];
                }

                int not_choose = dp[i][j-1];

                dp[i][j] = Math.max(choose , not_choose);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

}
