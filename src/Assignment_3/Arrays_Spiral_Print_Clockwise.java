package Assignment_3;

import java.util.Scanner;

/*

Take as input a 2-d array.Print the 2-D array in sprial form clockwise.

Input Format
Two integers M(row) and N(column) and further M * N integers(2-d array numbers).

Constraints
Both M and N are between 1 and 10.

Output Format
All M * N integers separated by commas with 'END' written in the end(as shown in example).

Sample Input
4 4
11 12 13 14
21 22 23 24
31 32 33 34
41 42 43 44
Sample Output
11, 12, 13, 14, 24, 34, 44, 43, 42, 41, 31, 21, 22, 23, 33, 32, END
Explanation
For spiral level clockwise traversal, Go for first row-> last column ->last row -> first column and
then do the same traversal for the remaining matrix .

*/
public class Arrays_Spiral_Print_Clockwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        printClockwise(arr);
    }

    static void printClockwise(int[][] arr){
        int row_start = 0;
        int col_start = 0;
        int row_end = arr.length - 1;
        int col_end = arr[0].length - 1;
        while (row_start <= row_end && col_start <= col_end){
            for(int i = col_start ; i <= col_end ; i++){
                System.out.print(arr[row_start][i] + " --> ");
            }
            System.out.println();
            row_start++;
            for(int i = row_start ; i <= row_end ; i++){
                System.out.print(arr[i][col_end] + " --> ");
            }
            System.out.println();
            col_end--;
            if(row_start <= row_end && col_start <= col_end){
                for(int i = col_end ; i >= col_start ; i--){
                    System.out.print(arr[row_end][i] + " --> ");
                }
                System.out.println();
                row_end--;

                for(int i = row_end ; i >= row_start ; i--){
                    System.out.print(arr[i][col_start] + " --> ");
                }
                System.out.println();
                col_start++;
            }
        }
    }
}
