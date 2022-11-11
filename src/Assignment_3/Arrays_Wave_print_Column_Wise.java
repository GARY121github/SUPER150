package Assignment_3;

/*

Take as input a two-d array. Wave print it column-wise.

Input Format
Two integers M(row) and N(colomn) and further M * N integers(2-d array numbers).

Constraints
Both M and N are between 1 to 10.

Output Format
All M * N integers seperated by commas with 'END' wriiten in the end(as shown in example).

Sample Input
4 4
11 12 13 14
21 22 23 24
31 32 33 34
41 42 43 44

Sample Output
11, 21, 31, 41, 42, 32, 22, 12, 13, 23, 33, 43, 44, 34, 24, 14, END


*/

import java.util.Scanner;

public class Arrays_Wave_print_Column_Wise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        printInWaveForm(arr);
    }

    static void printInWaveForm(int[][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            if(i%2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[j][i] + ", ");
                }
            }

            else{
                for (int j = arr[i].length - 1; j >= 0 ; j--) {
                    System.out.print(arr[j][i] + ", ");
                }
            }
        }
        System.out.println("END");
    }
}
