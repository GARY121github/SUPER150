package Assignment_4;

/*
Monu’s Maths Teacher at school gave him some numbers today, and she promised him a treat if he could find the
greatest product that he can make using any three of those numbers. He is very weak in his studies and is awful
with numbers, help him find the answer if the numbers are given as an array A, of size N.

Input Format
First line contains an integer N.
Second line contains N space-separated integers.

Constraints
3 <= N <= 10^5
|Ai| <= 10^3

Output Format
Single Integer, denoting the maximum product.

Sample Input
5
1 2 3 4 5
Sample Output
60

Explanation
The max product is given by 3, 4 and 5, which is 60

*/

import java.util.Arrays;
import java.util.Scanner;

public class Mental_Maths_Homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maximumProduct(arr));
    }

    static int maximumProduct(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int max = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        return max;
    }
}
