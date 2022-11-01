package Assignment_2;

import java.util.Scanner;

public class Calculate_The_Sum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int q = sc.nextInt();
        while(q-- > 0){
            int x = sc.nextInt();
            int[] brr = new int[x];
            for(int i = 0 ; i < n ; i++){
                if(i - x < 0){
                    brr[i] = arr[i] + arr[i - x + n];
                }
                else{
                    brr[i] = arr[i] + arr[i - x ];
                }
            }


            for(int i = 0 ; i < n ; i++){
                sum += brr[i];
            }
        }
        System.out.println(sum % (1e9 + 7));
    }
}
