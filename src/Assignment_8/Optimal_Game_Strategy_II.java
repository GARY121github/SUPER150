package Assignment_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Piyush and Nimit are playing a coin game. They are given n coins with values x1, x2 …. xn where 'n' is always even.
They take alternate terms. In each turn, a player picks either the first coin or the last coin from the row and removes
it from the row. The value of coin is received by that player. Determine the maximum value that Piyush can win with if
he moves first. Both the players play optimally.

Input Format
First line contains the number of coins 'n'.
Second line contains n space separated integers where ith index denotes the value of ith coin.

Constraints
1 < N <= 10000 , N is always even
0 <= Ai <= 1000000

Output Format
Print a single line with the maximum possible value that Piyush can win with.

Sample Input
4
1 2 3 4
Sample Output
6
Explanation
Piyush will pick the coin 4. Then Nimit can pick either 1 or 3. In both the cases Piyush picks coin 2 and wins with a
total of 6.
*/
public class Optimal_Game_Strategy_II {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }


}
