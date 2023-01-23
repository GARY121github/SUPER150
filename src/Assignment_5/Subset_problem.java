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

    }


}
