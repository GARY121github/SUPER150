package Class;

import java.util.*;

public class ReverseArray {
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]

//    [1,2,3,4,5,6,7]
//    [7 ,6 , 5 ,4 ,3 ,2 ,1] -> 1
//    7 ,6 ,5  -> 5 , 6 ,7
//    4 ,3 ,2 ,1 -> 1 ,2 ,3 ,4
//    [5 , 6 ,7 , 1 , 2 , 3 ,4]
    public static void main(String[] args) {
        int[] arr = {1,2 ,3 ,4,5 ,6 ,7};
//        rever(arr);

        rotateArr(arr , 3);
        System.out.println(Arrays.toString(arr));
    }
      /*
      *
      * (a++)   // 10
      * (a++)   //
      * (++a)
      *
      * */
    static void rotateArr(int[] arr , int k){
        for(int j = 1 ; j<=k ;j++) {
            int t = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = t;
        }
    }

    static void rever(int[] arr){
        // {1,2 ,3 ,4,5}
        // {5,4 ,3,2,1}
        int s = 0; // 1 3
        int e = arr.length - 1; // 5 3
        while (s < e){

            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;

            s++;
            e--;


        }



    }
}
