package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class k_largest_elements_GFG {
    public static void main(String[] args) {
        int N = 5, K = 2;
        int[] arr = {12, 5, 787, 1, 23};
        System.out.println(Arrays.toString(k_largest_elements(arr , K)));
    }
    private static int[] k_largest_elements(int[] arr , int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < arr.length ; i++){
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i] = heap.remove();
        }
        return ans;
    }
}
