package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
Cody went to the market to buy some oranges for his N friends. There he finds oranges wrapped in packets, with the price of i^th packet
as val[i].Now he wants to buy exactly W kg oranges, so he wants you to tell him what minimum price he should pay to buy exactly W kg
oranges. Weight of i^th packet is i kg. If price of i^th packet is -1 then this packet is not available for sale. The market has infinite
supply of orange packets.

Input Format
First line of input contains two space separated integers N and W, the number of friend he has and the amount of Oranges in kilograms
which he should buy.

The second line contains W space separated integers in which the i^th integer specifies the price of a ‘i’kg apple packet. A value
of -1 denotes that the corresponding packet is unavailable

Constraints
1 <= N,W,val[ ] <= 10^3

Output Format
Output a single integer denoting the minimum price Code should pay to get exactly W kg oranges. Else print -1 if it is not possible
to fill the bag.

Sample Input
5 5
1 2 3 4 5
Sample Output
5
*/
public class Minimum_Money_Needed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] val = new int[n];
        for (int i = 0 ; i < n ; i++){
            val[i] = sc.nextInt();
        }
        System.out.println(minimumCost(val , n , w));
    }

    public static long minimumCost(int cost[], int N,int W)
    {
        long[][] dp = new long[cost.length+1][W+1];
        for(long[] arr : dp){
            Arrays.fill(arr , -1);
        }
        long ans = minCost(cost , W , 0 , dp);
        if(ans == 1000000){
            return -1;
        }

        return ans;
    }
    private static long minCost(int[] cost , int w , int i , long[][] dp){
        if(w == 0){
            // System.out.println(ans);
            return 0;
        }

        if(w < 0 || i == cost.length){
            return 1000000;
        }

        if(dp[i][w] != -1){
            return dp[i][w];
        }

        long choose , not_choose;
        choose = not_choose = 1000000;

        if((i+1) <= w && cost[i] != -1){

            choose = cost[i] + minCost(cost , w - (i+1) , i , dp);
        }

        not_choose = minCost(cost , w , i+1 , dp);

        return dp[i][w] = Math.min(choose , not_choose);
    }
}
