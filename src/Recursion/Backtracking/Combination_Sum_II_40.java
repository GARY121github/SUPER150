package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates , target));
    }
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        sum(list , ans , candidates , target , 0 , 0);
        return list;
    }

    static void sum(List<List<Integer>> list , List<Integer> ans , int[] arr,  int target , int sum , int index){
        if(sum > target){
            return;
        }

        if(sum == target){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i = index ; i < arr.length ; i++){
            if(i == index || arr[i] != arr[i-1]){
                sum += arr[i];
                ans.add(arr[i]);
                sum(list , ans , arr , target , sum , i+1);
                sum -= arr[i];
                ans.remove(ans.size()-1);
            }
        }
    }
}
