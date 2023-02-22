package Divide_and_conquer;

import java.util.Arrays;

public class Greater_and_smaller {
    public static void main(String[] args) {
        int[] arr = {5,7,2,3,8,9,1,4};

    }

    static void partition(int[] arr , int si , int ei){
        int item = arr[ei];
        int pi = si;
        for(int i = si ; i < ei ; i++){
            if(arr[i] < item){
                int temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
                pi++;
            }
        }

        int temp = arr[pi];
        arr[pi] = arr[ei];
        arr[ei] = temp;
//        return pi;
    }
}
