package Divide_and_conquer;

import java.util.Arrays;

public class Merge_to_sorted_Arrays {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,8,9};
        int[] brr = {1,3,5,6,11,13,15};
        System.out.println(Arrays.toString(Merge(arr , brr)));
    }

    static int[] Merge(int[] arr , int[] brr){
        int[] crr = new int[arr.length + brr.length];

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < arr.length && p2 < brr.length){
            if(arr[p1] <= brr[p2]){
                crr[p++] = arr[p1++];
            }
            else{
                crr[p++] = brr[p2++];
            }
        }

        while (p1 < arr.length){
            crr[p++] = arr[p1++];
        }

        while (p2 < brr.length){
            crr[p++] = brr[p2++];
        }

        return crr;
    }
}
