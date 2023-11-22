package Assignment_8;

import java.util.Scanner;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, Print the maximum amount of money you
can rob tonight without alerting the police.

Input Format
First line takes an integer N(size of array)
Second line containing n space separated integer describing array

Constraints
1 <= N <= 100
0 <= nums[i] <= 1000

Output Format
Print the maximum amount of money you can rob tonight without alerting the police.

Sample Input
3
2 3 2
Sample Output
3
Explanation
You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
*/
public class House_Robber_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        for (int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            if(i != n-1){
                arr1[i] = x;
            }

            if(i != 0){
                arr2[i-1] = x;
            }
        }
        int f1 = tabulation(arr1);
        int f2 = tabulation(arr2);
        System.out.println(Math.max(f1 , f2));
    }
    private static int tabulation(int[] arr){
        int[] dp = new int[arr.length + 1];
        for(int i = 1 ; i < dp.length ; i++){
            int choose = arr[i-1];
            if(i > 1){
                choose += dp[i-2];
            }

            int not_choose = dp[i-1];

            dp[i] = Math.max(choose , not_choose);
        }
        return dp[arr.length];
    }
}
