package Assignment_8;

import java.util.HashMap;
import java.util.Scanner;

/*
Tughlaq introduces a strange monetary system. He introduces copper coins and each coin has a number written on it.
A coin n can be exchanged in a bank into three copper coins: n/2, n/3 and n/4. A coin can also be sold for gold.
One can get as much grams of gold as the number written on the coin. You have one copper coin.
What is the maximum weight of gold one can get from it?

Input Format
The input file contains a single integer n, the number on the coin.

Constraints
0 <= n <= 1 000 000 000

Output Format
Print the maximum weight of gold you can get.

Sample Input
12
Sample Output
13
*/
public class Exchanging_Coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        HashMap<Long , Long> map = new HashMap<>();
        System.out.println(maxGold(n , map));
    }

    private static long maxGold(long n , HashMap<Long , Long> map){
        if(n == 0){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }

        long n2 = maxGold(n/2, map);
        long n3 = maxGold(n/3, map);
        long n4 = maxGold(n/4, map);

        long ans = Math.max(n2+n3+n4 , n);
        map.put(n , ans);
        return ans;
    }
}
