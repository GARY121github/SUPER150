package Assignment_2;

import java.util.Scanner;

public class Kth_Root {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long k = sc.nextInt();
            System.out.println(kthroot(n , k));
        }
        // Your Code Here
    }

    static long kthroot(long n , long k){
        long s = 1;
        long e = n;
        long ans = 0;
        while (s <= e){
            long mid = s + (e - s) / 2;
            if(Math.pow(mid , k) <= n){
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
