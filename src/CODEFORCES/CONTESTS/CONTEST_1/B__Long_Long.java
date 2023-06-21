package CODEFORCES.CONTESTS.CONTEST_1;

import java.util.Scanner;

public class B__Long_Long {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < arr.length ; i++){
                arr[i] = sc.nextInt();
            }
            long[] ans = operations(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    static long[] operations(int[] arr){
        long[] ans = new long[2];
        int i = 0;
        while (i < arr.length){
            if(arr[i] >= 0){
                ans[0] += arr[i];
                i++;
            }
            else{
                ans[1]++;
                while (i < arr.length && arr[i] <= 0){
                    ans[0] += arr[i]*-1;
                    i++;
                }
            }
        }
        return ans;
    }
}
