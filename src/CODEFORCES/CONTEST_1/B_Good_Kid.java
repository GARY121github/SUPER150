package CODEFORCES.CONTEST_1;

import java.util.Scanner;

public class B_Good_Kid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }

            int min = 0;
            int minProduct = arr[0];
            for (int i = 1 ; i < n ; i++){
                if(arr[i] < minProduct){
                    min = i;
                    minProduct = arr[i];
                }
            }

            int maxProduct = 1;
            for (int i = 0 ; i < arr.length ; i++){
                if(i == min){
                    maxProduct *= arr[i]+1;
                }
                else{
                    maxProduct *= arr[i];
                }
            }

            System.out.println(maxProduct);
        }
    }
}
