package Assignment_5;

/*
Take an input N, a number. Take N more inputs and store that in an array. Take an input target, a number
a. Write a recursive function which prints subsets of the array which sum to target.
b. Write a recursive function which counts the number of subsets of the array which sum to target.
Print the value returned.
Input Format
Take an input N, a number. Take N more inputs and store that in an array. Take an input target, a number of
Constraints
None
Output Format
Display the number of subsets and print the subsets in a space separated manner.
Sample Input
3
1
2
3
3
Sample Output
1 2  3
2
Explanation
Add 2 spaces between 2 subset solutions
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Subset_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int t = subsetSum(arr , arr.length , target ,0 , "" , 0);
        System.out.println();
        System.out.println(t);
    }

    static int subsetSum(int arr[], int n, int sum, int s, String ans,
                         int count)
    {
        // The recursion is stopped at N-th level
        // where all the subsets of the given array
        // have been checked
        if (n == 0) {
            // Incrementing the count if sum is
            // equal to the subset and returning the count
            if (sum == s) {
                count++;
                for(int i = ans.length()-1 ; i>=0 ; i--){
                    System.out.print(ans.charAt(i)+ " ");
                }
                System.out.print(" ");
            }
            return count;
        }
        count = subsetSum(arr, n - 1, sum, s, ans , count);
        count = subsetSum(arr, n - 1, sum, s + arr[n - 1],  ans+arr[n-1],
                count);
        return count;
    }

}
