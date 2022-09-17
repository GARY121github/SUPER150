package Assignment_1;

import java.util.Scanner;

/*
A Boston number is a composite number, the sum of whose digits is the sum of the digits of its prime factors obtained
as a result of prime factorization (excluding 1 ). The first few such numbers are 4,22 ,27 ,58 ,85 ,94 and 121 .
For example, 378 = 2 × 3 × 3 × 3 × 7 is a Boston number since 3 + 7 + 8 = 2 + 3 + 3 + 3 + 7.
Write a program to check whether a given integer is a Boston number.

Input Format
There will be only one line of input:N , the number which needs to be checked.

Constraints
1 < N < 2,147,483,647 (max value of an integer of the size of 4 bytes)

Output Format
1 if the number is a Boston number. 0 if the number is a not Boston number.

Sample Input
378
Sample Output
1
Explanation
Self Explanatory
*/
public class Boston_Numbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = n;
        int sum_of_prime_factors = 0;
        int i = 2;
        while( i <= n){
            while(n%i == 0){
                sum_of_prime_factors += sum_of_digits(i);
                n = n/i;
            }

            i++;
        }
        num = sum_of_digits(num);
        if(sum_of_prime_factors == num)
            System.out.println('1');
        else
            System.out.println('0');
    }

    static int sum_of_digits(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
