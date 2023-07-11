package Heap.Leetcode;


import java.util.Collections;
import java.util.PriorityQueue;

public class Last_Stone_Weight_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones){
            maxHeap.add(i);
        }

        while (maxHeap.size() > 1){
            int y = maxHeap.remove();
            int x = maxHeap.remove();

            if(x == y){
                continue;
            }

            maxHeap.add(y-x);
        }
        if(maxHeap.isEmpty()){
            return 0;
        }
        else{
            return maxHeap.remove();
        }
    }
}
