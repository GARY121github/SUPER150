package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        System.out.println(factorial(n));
    }

    static long factorial(long n){
        if(n == 1){
            return n;
        }

        return n * factorial(n-1);
    }
}
