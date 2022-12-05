package Assignment_4;

import java.util.Scanner;

/*

In MATLAB, there is a handy function called reshape which can reshape an M × N matrix into a new one with a different
size R × C keeping its original data. You are given an M × N matrix MAT and two integers R and C representing the number
of rows and the number of columns of the wanted to be reshaped matrix. The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
NOTE: If to reshape isn’t possible print the original matrix.

Input Format
First line contains two integers M and N.
Next M lines contain N space separated integers.
Last line contains two integers R and C.

Constraints
1 <= M, N <= 100
1 <= R, C <= 300
|MATij| <= 103

Output Format
Print each row on a new line with the values separated by a space.

Sample Input
2 2
1 2
3 4
1 4
Sample Output
1 2 3 4
Explanation
The values of MAT are traversed row-wise, i.e. end of one row takes us to the start of next.

*/
public class Reshape_the_Matrix {
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

        int new_m = sc.nextInt();
        int new_n = sc.nextInt();

        convert_matrix(arr , new_m , new_n);
    }

    static void convert_matrix(int[][] arr , int m , int n){
        int[][] new_arr = new int[m][n];

        int row = 0;
        int col = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                new_arr[i][j] = arr[row][col];

                col++;

                if(col == arr[0].length){
                    row++;
                    col=0;
                }
            }
        }

        print(new_arr);
    }

    static void print(int[][] arr){
        for(int[] i : arr){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
