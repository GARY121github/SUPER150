package Assignment_8;

import java.util.Scanner;

/*
Reaching to the top of a staircase, it takes n steps.
The task can be accomplished either by climbing 1 step or 2 steps at a time.
In how many different ways can you climb to the top.
Note: n will be a positive integer.

Input Format
First line contains an integer n.

Constraints
None

Output Format
Print the total number of distinct ways you can climb to top.

Sample Input
2
Sample Output
2
Explanation
None
*/
public class Climbing_Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tabulation(n));
    }
    private static int memoization(int n , int[] dp){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int one_step = memoization(n-1 , dp);
        int two_step = memoization(n-2 , dp);

        return dp[n] = one_step + two_step;
    }

    private static int tabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            dp[i] = dp[i-1];

            if(i-2 >= 0){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
