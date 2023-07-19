package Hashmap_and_Hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_II_350 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Intersection_of_Two_Arrays_II_350 ob = new Intersection_of_Two_Arrays_II_350();
        System.out.println(Arrays.toString(ob.intersect(nums1 , nums2)));


    }
    public int[] intersect(int[] arr1, int[] arr2) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : arr1){
            if(map.containsKey(i)){

                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i : arr2){
            if(map.containsKey(i) && map.get(i) > 0){
                map.put(i , map.get(i) - 1);
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}
