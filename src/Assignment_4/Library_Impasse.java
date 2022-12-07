package Assignment_4;

import java.util.Arrays;
import java.util.Scanner;

/*

Monu Bhaiya is in a library. He approaches a shelf which has N books and each book has some amount of perks.
Monu Bhaiya randomly chooses any book and decides to read all the books on its left or all the books on its right,
depending on which side has minimum perks for all the books combined.
However, he reaches an impasse, if the perks for all the books together on either side are equal.
You are given an array A, of size N. Ai denotes the perk of a book. Print the index of the book for which Monu Bhaiya reaches
an impasse.
Note: If there is no such index, then print “-1” and if there are multiple indices, print the leftmost index.

Input Format
First line contains an integer N.
Second line contains N space-separated integers, representing the perks.

Constraints
1 <= N <= 10^4
|Ai| <= 10^3

Output Format
A number denoting the index of impasse, or -1 if no solution.

Sample Input
6
1 7 3 6 5 6
Sample Output
3
Explanation
For index 3, perk on its left = 1+7+3 = 11, perk on its right = 5+6 = 11, hence Monu Bhaiya reaches an impasse at index 3.

*/

// 1  8 11 17 22 28
//28 27 20 17 11 6
public class Library_Impasse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }

    static int solution(int[] arr){
//        LEFT SIDE
//        System.out.println(Arrays.toString(arr));
        int[] left = new int[arr.length];
        left[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            left[i] = left[i-1] + arr[i];
        }
//        System.out.println(Arrays.toString(left));
//        RIGHT SIDE
        int[] right = new int[arr.length];
        right[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length - 2; i >= 0 ; i--){
            right[i] = right[i+1] + arr[i];
        }
//        System.out.println(Arrays.toString(right));
        int p1 = 0;
        int p2 = arr.length-1;
//        int count = 0;
        while (p1 <= p2){
//            count++;
            if(left[p1] == right[p2]){
                return p1+1;
            } else if (left[p1] > right[p2]) {
                p2--;
            }
            else {
                p1++;
            }
        }

        return -1;
    }
}
