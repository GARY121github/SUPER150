package Recursion.Backtracking;

import java.util.ArrayList;

public class Combination_Sum_IV_377 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 4;
        System.out.println(combination_Sum4(arr , target  , 0));
    }
    static int combination_Sum4(int[] arr, int target, int sum) {
        if(sum > target){
            return 0;
        }
        if(sum == target){
            return 1;
        }

        int count = 0;
        for (int i = 0 ; i < arr.length ; i++){
            count += combination_Sum4(arr, target, sum + arr[i]);
        }

        return count;
    }
}
