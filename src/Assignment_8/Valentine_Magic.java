package Assignment_8;

import java.util.Arrays;
import java.util.Scanner;

/*
It's Valentine's Day in Russia today. as we all know number of girls in Russia is more than number of boys 😜 hence boys
have an extra advantage while choosing girl for the valentine evening. Each boy has certain number of chocolates and each
girl has certain number of candies. Now you being the anchor of evening wants to pair all the boys with girls such that
the sum of absolute difference between boy's chocolate and girl's candy in a pair is minimized. Ofcourse some of the girls
will remain unpaired but that's okay as we are in Russia 😜

Input Format
The first line consists of two integers N and M. then follow N integers in second line. Then follow M integers in third line.
M >= N

Constraints
1 <= N <= 5000
1 <= M <= 5000
M >= N
1 <= chocolates <= 1000000
1 <= candies <= 1000000

Output Format
The only line which consists of required sum of absolute differences.

Sample Input
2 5
4 5
1 2 3 4 5
Sample Output
0
Explanation
we can pair boy numbered 1 with girl numbered 4 and boy numbered 2 with girl numbered 5
*/
public class Valentine_Magic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] boys = new int[n];
        int[] girls = new int[m];

        for (int i = 0 ; i < n ; i++){
            boys[i] = sc.nextInt();
        }

        for (int j = 0 ; j < m ; j++){
            girls[j] = sc.nextInt();
        }
        Arrays.sort(boys);
        Arrays.sort(girls);

//        int[][] dp = new int[n][m];
//        System.out.println(knapSack(boys , boys.length - 1 , girls , girls.length - 1 , dp));

        System.out.println(tabulation(boys , girls));
    }
    private static int knapSack(int[] boys , int i , int[] girls , int j , int[][] dp){
        if(i == -1){
            return 0;
        }

        if(j == -1){
            return 1000000;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int choose = Math.abs(boys[i] - girls[j]) + knapSack(boys , i-1 , girls , j-1 , dp);

        int not_choose = knapSack(boys , i , girls , j-1 , dp);

        return dp[i][j] = Math.min(choose , not_choose);
    }

    private static int tabulation(int[] boys , int[] girls){
        int[][] dp = new int[boys.length+1][girls.length+1];

        for (int i = 1 ; i <= boys.length ; i++){
            dp[i][0] = 1000000;
        }

        for (int i = 1 ; i < dp.length ; i++){
            for (int j = 1 ; j < dp[0].length ; j++){

                int choose = Math.abs(boys[i-1] - girls[j-1]) + dp[i-1][j-1];
                int not_choose = dp[i][j-1];

                dp[i][j] = Math.min(choose , not_choose);
            }
        }

        return dp[boys.length][girls.length];
    }
}
