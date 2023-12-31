package Assignment_5;

import java.util.Scanner;

/*
Take as input N, a number. Take N more inputs and store that in an array.

a. Write a recursive function which counts the number of ways the array could be split in two groups,
so that the sum of items in both groups is equal. Each number in the array must belong to one of the two groups.
Print the value returned.

b. Write a recursive function which keeps track of ways an array could be split in two groups, so that the sum of items
in both groups is equal. Each number in the array must belong to one of the two groups. Return type of function should
be void. Print the two groups, each time you find a successful split.

Input Format
Take as input N, a number. Take N more inputs and store that in an array.
Constraints
None

Output Format
Display all the groups in a comma separated manner and display the number of ways the array can be split

Sample Input
6
1
2
3
3
4
5
Sample Output
1 2 3 3 and 4 5
1 3 5 and 2 3 4
1 3 5 and 2 3 4
2 3 4 and 1 3 5
2 3 4 and 1 3 5
4 5 and 1 2 3 3
6
*/
public class Split_array_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
    }
}
