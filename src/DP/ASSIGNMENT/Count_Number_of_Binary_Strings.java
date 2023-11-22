package DP.ASSIGNMENT;

import java.util.Arrays;
import java.util.Scanner;

/*
You are provided an integers N. You need to count all possible distinct binary strings of length N such that there are no
consecutive 1’s.

Input Format
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the length of
Binary String.

Constraints
1<=t<=100 1<=n<=90

Output Format
Print the number of all possible binary strings.

Sample Input
2
2
3
Sample Output
3
5
Explanation
1st test case : 00, 01, 10
2nd test case : 000, 001, 010, 100, 101
*/
public class Count_Number_of_Binary_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            long n = sc.nextLong();
            System.out.println(distinctBinary(n));
        }
    }

    private static long distinctBinary(long n){
        long zero_ending = 1;
        long one_ending = 1;
        long sum = zero_ending + one_ending;
        if(n == 1){
            return sum;
        }

        for(long i = 2 ; i <= n ; i++){
            one_ending = zero_ending;
            zero_ending = sum;
            sum = one_ending + zero_ending;
        }

        return sum;
    }
}
