package Assignment_6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 You are given given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray)
 of size k. If a window does not contain a negative integer, then print 0 for that window.

 Input Format
 First line contains integer t as number of test cases. Each test case contains two lines. First line contains two integers n and k
 where n is length of the array and k is the size of window and second line contains n space separated integer.

 Constraints
 1 < t < 10 1< n, k < 10000000

 Output Format
 For each test case you have to print the required output as given below.

 Sample Input
 2
 8 3
 12 -1 -7 8 -15 30 16 28
 8 4
 12 -1 -7 8 -15 30 16 28
 Sample Output
 -1 -1 -7 -15 -15 0
 -1 -1 -7 -15 -15
 Explanation
 For first test case : Subarray of window size 3 is ( 12 -1 -7), (-1, -7, 8), and so on.. Take first negative number from each window
 and print them.
 **/
public class First_negative_integer_in_every_window_of_size_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < arr.length ; i++){
                arr[i] = sc.nextInt();
            }
            negativeWindow(arr , k);
        }
    }

    static void negativeWindow(int[] arr , int k){
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int s = 0 ;
        while (s < k){
            if(arr[s] < 0){
                deque.add(s);
            }
            s++;
        }
//        System.out.println(deque);
        if(deque.isEmpty()) {
            ans[0] = 0;
        }
        else {
            ans[0] = arr[deque.peek()];
        }
        int pos = 1;
        while (s < arr.length){

            while (!deque.isEmpty() && s - deque.peek() >= k){
                deque.removeFirst();
            }

            if(arr[s] < 0){
                deque.add(s);
            }
            if(!deque.isEmpty())
                ans[pos++] = arr[deque.peek()];
            else
                ans[pos++] = 0;
            s++;
//            System.out.println(deque);
        }
        display(ans);

    }

    private static void display(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
