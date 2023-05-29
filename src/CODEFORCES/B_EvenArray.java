package CODEFORCES;

import java.util.Scanner;

public class B_EvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(moves(arr));
        }
    }

    static int moves(int[] arr){
        int even , odd , fine;
        even = odd = fine = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i % 2 == arr[i] % 2){
                fine++;
            }
            else if(i%2 == 0 && arr[i]%2 != 0){
                even++;
            }
            else{
                odd++;
            }
        }
//        System.out.println(even + " " + odd + " " + fine);
        if(fine == arr.length){
            return 0;
        }
        else if(even == odd){
            return even;
        }
        else{
            return -1;
        }
    }
}
