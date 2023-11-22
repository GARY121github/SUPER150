package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
Given N, count the number of ways to express N as sum of 1, 3 and 4.

Input Format
First line contains the size of the array. Next line contains array elements.

Constraints
1 <= N <= 108

Output Format
Print the integer answer.

Sample Input
4
Sample Output
4
Explanation
1+1+1+1
1+3
3+1
4
*/
public class Count_of_different_ways_to_express_N_as_the_sum_of_1_3_and_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
//        Arrays.fill(dp , -1);
//        System.out.println(memoization(n , dp));
        System.out.println(tabulation(n));
    }
    private static long memoization(int n , long[] dp){
        if(n == 0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        long count = 0;

//        choose 1
        count += memoization(n-1 , dp);

//        choose 3
        if(n >= 3){
            count += memoization(n-3 , dp);
        }

//        choose 4
        if(n >= 4){
            count += memoization(n-4 , dp);
        }

        return dp[n] = count;
    }

    private static long tabulation(int n){
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 1 ; i <= n ; i++){
//            choose 1
            long count = dp[i-1];

//            choose 3
            if(i-3 >= 0){
                count += dp[i-3];
            }

//            choose 4
            if(i-4 >= 0){
                count += dp[i-4];
            }

            dp[i] = count;
        }

        return dp[n];
    }
}
