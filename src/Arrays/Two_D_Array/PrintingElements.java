package Arrays.Two_D_Array;

import java.util.Arrays;
import java.util.Scanner;

public class PrintingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][4];
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.toString(arr));
        printing(arr);
    }

    static void printing(int[][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                System.out.println(arr[j][i]);
            }
        }
    }
}
