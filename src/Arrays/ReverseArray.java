package Arrays;

import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1 , 2 , 3 , 4 , 5};

    }

    static int[] rangeReverse(int s , int e ,int arr[]){
        while (s < e){
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;

            s++;
            e--;
        }
        return arr;
    }
}
