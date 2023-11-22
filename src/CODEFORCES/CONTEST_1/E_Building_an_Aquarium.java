package CODEFORCES.CONTEST_1;

import java.util.Scanner;
import java.util.Stack;

public class E_Building_an_Aquarium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int maxHeight = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
//            System.out.println(rainWaterTrapping(arr, maxHeight));
        }
    }

//    private static int rainWaterTrapping(int[] height, int max) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int ans = 0;
//        for (int i = 0 ; i < height.length ; i++){
//            while (!stack.isEmpty())
//        }
//
//    }
}
