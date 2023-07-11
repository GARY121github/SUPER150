package Heap.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        int[] ans = new int[k];
        int pos = 0;
        while (k-- > 0){
            ans[pos++] = maxHeap.poll();
        }
        return ans;
    }
}
