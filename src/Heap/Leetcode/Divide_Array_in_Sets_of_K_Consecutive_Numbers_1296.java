package Heap.Leetcode;

import java.util.*;

public class Divide_Array_in_Sets_of_K_Consecutive_Numbers_1296 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,6};
        int k = 4;
        System.out.println(isPossibleDivide(arr , k));
    }
    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(nums);
        for (int a : nums) {
            if (map.get(a) > 0) {
                for (int i = 0; i < k; i++) {
                    if (!map.containsKey(a + i) || map.get(a + i) == 0) {
                        return false;
                    } else {
                        map.put(a + i, map.get(a + i) - 1);
                    }
                }
            }
        }
        return true;
    }
}
