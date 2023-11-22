package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up.

Input Format
First line contains an integer t denoting the number of test cases. Next t lines contain an integer n each.

Constraints
1<= n < 30

Output Format
Output t lines each line describing the answer.

Sample Input
1
3
Sample Output
4
Explanation
{1}, {2}, {3} : all single {1}, {2,3} : 2 and 3 paired but 1 is single. {1,2}, {3} : 1 and 2 are paired but 3 is single. {1,3},
{2} : 1 and 3 are paired but 2 is single. Note that {1,2} and {2,1} are considered same.
*/
public class Friends_Pairing_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[31];
        while (t-- > 0){
            int n = sc.nextInt();
            System.out.println(countFriendsPairings(n));
//            System.out.println(ways(n , dp));
        }
    }

    public static long countFriendsPairings(int n)
    {
        long[] dp = new long[n+1];
        Arrays.fill(dp , -1);
        return pairing(n , dp);
    }

    private static long pairing(int n , long[] dp){
        if(n <= 2){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        long single = pairing(n-1 , dp);
        long pair = (n-1) * pairing(n-2 , dp);

        return dp[n] = (single + pair) % 1000000007;
    }



}
