package Assignment_8;

import java.util.Scanner;

/*
Prateek went to purchase fruits mainly apples, mangoes and oranges. There are N different fruit sellers in a line.
Each fruit seller sells all three fruit items, but at different prices. Prateek, obsessed by his nature to spend optimally,
decided not to purchase same fruit from adjacent shops. Also, Prateek will purchase exactly one type of fruit item (only 1kg)
from each shop.
Prateek wishes to spend minimum money buying fruits using this strategy. Help Prateek determine the minimum money he will
spend. If he becomes happy, he may offer you discount on your favorite course in Coding Blocks ;). All the best!

Input Format
First line indicates number of test cases T. Each test case in its first line contains N denoting the number of fruit sellers
in Fruit Market. Then each of next N lines contains three space separated integers denoting cost of apples, mangoes and
oranges per kg with that particular fruit seller.

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 10^5
Cost of each fruit(apples/mangoes/oranges) per kg does not exceed 10^4

Output Format
For each test case, output the minimum cost of shopping taking the mentioned conditions into account in a separate line.

Sample Input
2
3
1 50 50
50 50 50
1 50 50
4
1 2 3
3 2 1
1 1 1
1 1 1
Sample Output
52
4
Explanation
Test Case 1:
There are two ways, each one gives 52 as minimum cost. One way is buy apples from first shop, mangoes from second shop
and apples from third shop or he can buy apples from first shop, oranges from second shop and apples from third shop.

Both ways , cost comes up to 1 + 50 + 1 = 52

Test Case 2:
Answer is 4. Total 6 ways
*/
public class Buying_Fruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] shop = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    shop[i][j] = sc.nextInt();
                }
            }
//            int[][] dp = new int[n][4];
//            System.out.println(buyFruits(shop, shop.length - 1, 3, dp));
            System.out.println(tabulation(shop));
        }
    }

    private static int buyFruits(int[][] shop, int index, int prev, int[][] dp) {
        if (index == -1) {
            return 0;
        }

        if (dp[index][prev] != 0) {
            return dp[index][prev];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != prev) {
                int curr = shop[index][i] + buyFruits(shop, index - 1, i, dp);
                ans = Math.min(curr, ans);
            }
        }

        return dp[index][prev] = ans;
    }

    private static int tabulation(int[][] shop) {
        int[][] dp = new int[shop.length + 1][4];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                int ans = Integer.MAX_VALUE;
                for (int k = 1; k < 4; k++) {
                    if (k != j) {
                        int curr = shop[i - 1][k - 1] + dp[i - 1][k];
                        ans = Math.min(ans, curr);
                    }
                }

                dp[i][j] = ans;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1 ; i < 4 ; i++){
            min = Math.min(dp[shop.length][i] , min);
        }

        return min;
    }

}
