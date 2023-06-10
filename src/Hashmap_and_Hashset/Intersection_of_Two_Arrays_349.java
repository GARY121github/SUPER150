package Hashmap_and_Hashset;

import java.util.*;

public class Intersection_of_Two_Arrays_349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
    }
    public int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : arr2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }

        int[] ans = new int[list.size()];
        int j = 0;
        for(int i : list){
            ans[j++] = i;
        }
        return ans;
    }

}
