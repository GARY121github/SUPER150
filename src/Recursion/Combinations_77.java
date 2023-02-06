package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
//        n = 4, k = 2
//        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        int n = 4;
        int k = 2;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(Combine(n , k , 1 , list));
    }

    static List<List<Integer>> Combine(int n, int k , int index , ArrayList<Integer> ans) {
        List<List<Integer>> list = new ArrayList<>();
        if(ans.size() == k){
            list.add(new ArrayList<>(ans));
            return list;
        }

        for (int i = index ; i <= n ; i++){
            ans.add(i);
            list.addAll(Combine(n , k , i+1 , ans));
            ans.remove(ans.size()-1);
        }

        return list;
    }

}
