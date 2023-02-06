package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_III_216 {
    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k , n));
    }
    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        sum(list , ans , k , n , 0 , 1);
        return list;
    }

    static void sum(List<List<Integer>> list , List<Integer> ans , int k,  int n , int sum , int index){
        if(sum > n || ans.size() > k){
            return;
        }

        if(sum == n && ans.size() == k){
            list.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index ; i < 10 ; i++){
            ans.add(i);
            sum(list , ans , k, n , sum + i , i+1);
            ans.remove(ans.size()-1);
        }
    }
}
