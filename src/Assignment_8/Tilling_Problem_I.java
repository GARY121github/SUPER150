package Assignment_8;

import java.util.HashMap;
import java.util.Scanner;

/*
Given a board of size 2xn , you have place 2x1 tiles . You can place the tile horizontally or vertically .
Print the number of ways.

Input Format
Size n

Constraints
1<= n <= 100

Output Format
Number of ways

Sample Input
7
Sample Output
21
*/
public class Tilling_Problem_I {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numberOfWays(n));
    }
    static Long numberOfWays(int n) {
        HashMap<Integer , Long> dp = new HashMap<>();
        return tileFloor(n , dp);
    }

    private static long tileFloor(int n , HashMap<Integer , Long> dp){
        if(n <= 2){
            return (long) n;
        }

        if(dp.containsKey(n)){
            return dp.get(n);
        }

        long ans = (tileFloor(n-1 , dp) + tileFloor(n-2 , dp));

        dp.put(n , ans);

        return ans;
    }
}
