package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/
public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxWindow(arr , k)));
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
