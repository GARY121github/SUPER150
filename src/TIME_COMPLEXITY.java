import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TIME_COMPLEXITY {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Arrays.sort(arr);
        int ans = binarySearch(arr , target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr , int target){
        int s = 1;
        int e = arr[arr.length - 1];
        while(s < e){
            int mid = s + (e-s) / 2;
            int count = 0;
            System.out.println("hello");
            for(int i = 0; i < arr.length ; i++){
                if(arr[i] > mid)
                    count += (arr[i] - mid);
            }

            if(count >= target){
                s = mid;
            }
            else{
                e = mid - 1;
            }
        }
        return s;
    }
}
