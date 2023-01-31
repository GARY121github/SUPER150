package Sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elements_658 {
    public static void main(String[] args) {
//        arr = [1,2,3,4,5], k = 4, x = 3
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        System.out.println(find_Closest_Elements(arr , k , x));
    }
    static List<Integer> find_Closest_Elements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        int sum = 0;
//        MAKE WINDOW
        while (e < k){
            sum += Math.abs(arr[e]-x);
            e++;
        }
        int first = 0;
        int second = k-1;
        int current_sum = sum;
        while (e < arr.length){
//            GROW
            current_sum += Math.abs(arr[e]-x);
//            SHRINK
            current_sum -= Math.abs(arr[s]-x);
            s++;
            if(current_sum < sum){
                sum = current_sum;
                first = s;
                second = e;
            }
            e++;
        }
        while (first <= second){
            list.add(arr[first]);
            first++;
        }

        return list;

    }
}
