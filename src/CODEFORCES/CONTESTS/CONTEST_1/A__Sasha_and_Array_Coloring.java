package CODEFORCES.CONTESTS.CONTEST_1;

import java.util.Arrays;
import java.util.Scanner;

public class A__Sasha_and_Array_Coloring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(coloring(arr));
        }
    }

    static int coloring(int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        int s = 0;
        int e = arr.length - 1;
        while (s <= e){
            sum += (arr[e] - arr[s]);
            e--;
            s++;
        }
        return sum;
    }
}
