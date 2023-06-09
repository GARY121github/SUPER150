package Heap;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0 ; i < k ; i++){
            heap.add(arr[i]);
        }
        for(int i = k ; i < arr.length ; i++){
            if(arr[i] > heap.peek()){
                heap.poll();
                heap.add(arr[i]);
            }
        }

//        return heap.poll();
    }
}
