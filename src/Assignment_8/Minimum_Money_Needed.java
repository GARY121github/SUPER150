package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
Cody went to the market to buy some oranges for his N friends. There he finds oranges wrapped in packets, with the price of
i^th packet as val[i].
Now he wants to buy exactly W kg oranges, so he wants you to tell him what minimum price he should pay to buy exactly W kg
oranges. Weight of i^th packet is i kg. If price of i^th packet is -1 then this packet is not available for sale. The market
has infinite supply of orange packets.

Input Format
First line of input contains two space separated integers N and W, the number of friend he has and the amount of Oranges in
kilograms which he should buy.

The second line contains W space separated integers in which the i^th integer specifies the price of a ‘i’kg apple packet.
A value of -1 denotes that the corresponding packet is unavailable

Constraints
1 <= N,W,val[ ] <= 10^3

Output Format
Output a single integer denoting the minimum price Code should pay to get exactly W kg oranges. Else print -1 if it is not
possible to fill the bag.

Sample Input
5 5
1 2 3 4 5

Sample Output
5
*/
public class Minimum_Money_Needed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][n];
        for (int[] a : dp){
            Arrays.fill(a , -1);
        }
        int minPrice = minPrice(arr , n , 0 , dp);
        System.out.println(minPrice >= 1000000 ? -1 : minPrice);
    }
    private static int minPrice(int[] arr , int w , int index , int[][] dp){
        if(w == 0){
            return 0;
        }

        if(index == arr.length){
            return 1000000;
        }

        if(dp[w][index] != -1){
            return dp[w][index];
        }

        int choose = 1000000;
        if (index+1 <= w && arr[index] != -1){
            choose = arr[index] + minPrice(arr , w - (index+1) , index , dp);
        }

        int not_choose = minPrice(arr , w , index+1 , dp);

        return dp[w][index] = Math.min(choose , not_choose);
    }
}
