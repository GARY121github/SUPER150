package Heap.Assignment;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Find the kth largest element in an unsorted array.
Note:It is the kth largest element in the sorted order, not the kth distinct element.

Input Format
First line contains integer n as size of array. Second line contains the value of k. Third line contains n integers as element of array.

Constraints
1 ≤ k ≤ array's length.

Output Format
Print the kth largest element as output.

Sample Input
6
2
3 2 1 5 6 4
Sample Output
5
*/
public class Find_kth_Largest_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < n ; i++){
            heap.add(sc.nextInt());
        }
        while (!heap.isEmpty() && k > 1){
            k--;
            heap.remove();
        }
        System.out.println(heap.remove());
    }
}
