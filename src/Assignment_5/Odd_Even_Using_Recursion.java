package Assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 /*
Take as input N, a number. Print odd numbers in decreasing sequence (up until 0) and even numbers in increasing
sequence (up until N) using Recursion

Input Format
Constraints
1 <= N <=1000

Output Format
Sample Input
5
Sample Output
5
3
1
2
4
 */
public class Odd_Even_Using_Recursion {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n%2 == 0){
            odd(n-1);
            even(n);
        }else {
            odd(n);
            even(n-1);
        }
    }

    static void odd(int n){
        if(n < 0){
            return;
        }
        System.out.println(n);
        odd(n-2);
    }

    static void even(int n){
        if (n <= 0){
            return;
        }
        even(n-2);
        System.out.println(n);
    }

}
