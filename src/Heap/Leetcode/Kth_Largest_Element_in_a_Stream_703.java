package Heap.Leetcode;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream_703 {
    class KthLargest {
        PriorityQueue<Integer> heap;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            for (int i : nums){
                heap.add(i);
            }
        }

        public int add(int val) {
            heap.add(val);

            while (heap.size() > k){
                heap.remove();
            }
            return heap.peek();
        }
    }
}
