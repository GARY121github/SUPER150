package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args) {
       int[] candidates = {2,3,6,7};
       int target = 7;
        System.out.println(combinationSum(candidates , target));
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            sum += arr[i];
            ans.add(arr[i]);
            sum(list , ans , arr , target , sum , i);
            sum -= arr[i];
            ans.remove(ans.size()-1);
        }
    }
}
