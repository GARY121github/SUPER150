package Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {

    }

    static int[] maxWindow(int[] arr , int k){
        int n = arr.length;
        int[] max = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){

            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]){
                deque.removeLast();
            }

            deque.add(i);
        }
        max[0] = arr[deque.getFirst()];
        int j = 1;
        for(int i = k ; i < n ; i++){

            while (!deque.isEmpty() && deque.getFirst() <= i - k){
                deque.remove();
            }

            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]){
                deque.removeLast();
            }

            deque.add(i);

            max[j++] = arr[deque.getFirst()];
        }

        return max;
    }
}
