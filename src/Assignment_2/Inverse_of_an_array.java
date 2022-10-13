package Assignment_2;

import java.util.Scanner;

public class Inverse_of_an_array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        inverseArray(1 , arr , n-1);
        for(int i = 0 ; i < n ; i++)
            System.out.print(arr[i] + " ");
        // Your Code Here
    }

    static void inverseArray(int i , int[] arr , int j){
        if(i >= j){
            return;
        }

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

        inverseArray(++i , arr , --j);
    }
}
