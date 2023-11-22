package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
Find the length of the longest subsequence in a given array A of integers such that all elements of the subsequence are
sorted in strictly ascending order.

Input Format
The first line contains a single integer n.
Next line contains n space separated numbers denoting the elements of the array.

Constraints
0 < n< 10^5
0 < Ai < 10^5

Output Format
Print a single line containing a single integer denoting the length of the longest increasing subsequence.

Sample Input
6
50 3 10 7 40 80
Sample Output
4
Explanation
The longest subsequence in test case is : 3,7,40,80
*/
public class Longest_Increasing_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(LIS(arr));
    }
    private static int LIS(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp , 1);
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i : dp){
            max = Math.max(i , max);
        }

        return max;
    }
}
