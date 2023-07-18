package Heap.Assignment;

import java.util.HashMap;
import java.util.Scanner;

/*
Given an array, the task is to calculate the sum of lengths of contiguous sub-arrays having all elements distinct

Input Format
An integer n denoting size of array followed by n integers

Constraints
1<=N<=10^5

Output Format
The answer mod 10^9+7

Sample Input
3
1 2 3
Sample Output
10
Explanation
{1, 2, 3} is a sub-array of length 3 with distinct elements. Total length of length three = 3. {1, 2}, {2, 3} are 2 sub-array of length
2 with distinct elements. Total length of lengths two = 2 + 2 = 4 {1}, {2}, {3} are 3 sub-arrays of length 1 with distinct element.
Total lengths of length one = 1 + 1 + 1 = 3 Sum of lengths = 3 + 4 + 3 = 10
*/
public class Subarrays_with_distinct_elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sum_of_length(arr));
    }

    private static int sum_of_length(int[] arr){
        int ans = 0;
        int s = 0;
        int e = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        while (e < arr.length){
//            GROW
            map.put(arr[e] , map.getOrDefault(arr[e] , 0) + 1);

//            SHRINK
            while (!map.isEmpty() && map.get(arr[e]) > 1){
                map.put(arr[s] , map.get(arr[s]) - 1);
                if(map.get(arr[s]) == 0){
                    map.remove(arr[s]);
                }
                s++;
            }

            ans += ( (e-s+1) * (e-s+2) ) / 2;
//            System.out.println(ans);
            e++;
        }
//        ans += e-s+1;
        return ans;
    }
}
