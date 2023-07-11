package Heap.Assignment;

import java.util.HashMap;
import java.util.Scanner;

/**
 Given an array find the number which comes with maximum frequency. It must work in O(n) time complexity.

 Input Format
 Enter the size of the array N and add N more numbers and store in an array

 Constraints
 1 <= N <= 10^7
 -109 <= A[i] <= 109

 Output Format
 Display the number with the maximum frequency.

 Sample Input
 5
 1 2 2 2 3
 Sample Output
 2
 Explanation
 2 has the highest frequency in the array i.e. 3.
 **/
public class Highest_frequency_Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i : arr){
            if (map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }

        int highest_freq = 0;
        int ans = 0;
        for (int i : map.keySet()){
            if(map.get(i) > highest_freq){
                highest_freq = map.get(i);
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
