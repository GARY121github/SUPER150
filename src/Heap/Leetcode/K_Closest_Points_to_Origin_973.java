package Heap.Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin_973 {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a , int[] b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for (int[] arr : points){
            heap.add(arr);
        }
        int[][] ans = new int[k][2];
        int pos = 0;
        while (k-- > 0){
            ans[pos++] = heap.remove();
        }
        return ans;
    }
}
