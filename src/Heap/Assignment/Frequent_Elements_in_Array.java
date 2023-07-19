package Heap.Assignment;

import java.util.*;

/*
Given an integer array nums and an integer k, Print the k most frequent elements. You have return the answer in sorted order.

Input Format
The first line contains two Integer space-separated integers N (array size) and K.

The second line contains Element of Array

Constraints
1 < = N <= 105
-104 <= arr[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Output Format
Single Line consisting of K frequent elements in sorted order ,where each number is separated by space.

Sample Input
6  2
1 1 1 3 2 2
Sample Output
1 2
Explanation
None
*/
public class Frequent_Elements_in_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            map.put(x , map.getOrDefault(x , 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) != map.get(o2)){
                    return map.get(o2) - map.get(o1);
                }
                else{
                    return o2 - o1;
                }
            }
        });
        maxHeap.addAll(map.keySet());
        ArrayList<Integer> list = new ArrayList<>();
        while (k-- > 0){
            list.add(maxHeap.remove());
        }
        Collections.sort(list);
        for (int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
