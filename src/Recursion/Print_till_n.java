package Recursion;

import java.util.Scanner;

public class Print_till_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }

    static void printReverse(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printReverse(n-1);
    }

    static void print(int n){
        if(n == 0){
            return;
        }
        print(--n);
        System.out.println(n);
    }
}
