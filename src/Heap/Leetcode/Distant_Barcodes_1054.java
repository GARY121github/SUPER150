package Heap.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Distant_Barcodes_1054 {
    public static void main(String[] args) {

    }
    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i : barcodes){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        int[] ans = new int[barcodes.length];
        int pos = 0;
        while (heap.size() > 0){
            int data = heap.poll();
            int freq = map.get(data);
            while (freq-- > 0){
                if(pos >= ans.length){
                    pos = 1;
                }
                ans[pos] = data;
                pos += 2;
            }
        }
        return ans;
    }
}
