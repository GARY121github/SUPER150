package Heap.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 Take as input N, the size of array. Take N more inputs and store that in an array. Take N more inputs and store that in another array.
 Write a function which gives the intersection of two arrays in an ArrayList of integers and Print the ArrayList.

 Input Format
 First line contains N denoting the size of the two arrays. Second line contains N space separated integers denoting the elements of
 the first array. Third line contains N space separated integers denoting the elements of the second array.

 Constraints
 Length of Arrays should be between 1 to 100000.

 Output Format
 Display the repeating elements in a comma separated manner enclosed in square brackets. The numbers should be sorted in increasing
 order.

 Sample Input
 7
 1 2 3 1 2 4 1
 2 1 3 1 5 2 2
 Sample Output
 [1, 1, 2, 2, 3]
 Explanation
 Check which integer is present in both the arrays and add them in an array .Print this array as the ans.


 **/
public class Arrays_Intersection_Of_Two_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0 ; i < n ; i++){
            brr[i] = sc.nextInt();
        }
        System.out.println(intersections(arr , brr));
    }

    static ArrayList<Integer> intersections(int[] arr , int[] brr){
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : arr){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }else {
                map.put(i , 1);
            }
        }
//        System.out.println(map);
        for (int i : brr){
            if(map.containsKey(i) && map.get(i) > 0){
                map.put(i , map.get(i) - 1);
                ans.add(i);
            }
        }
//        System.out.println(map);

        Collections.sort(ans);
        return ans;
    }
}
