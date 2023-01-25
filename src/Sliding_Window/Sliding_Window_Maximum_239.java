package Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;

public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums , k)));
    }

    static int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        ArrayList<Integer> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        while(e < k){
            list.add(arr[e]);
            e++;
        }
        ans[s++] = searchMax(list);
        while (e < arr.length){
            list.add(arr[e]);
            list.remove(0);
            ans[s++] = searchMax(list);
            e++;
        }

        return ans;
    }

    static int searchMax(ArrayList<Integer> list){
        int max = list.get(0);
        for(int i : list){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
