package Sliding_Window;

public class Max_Consecutive_Ones_III_1004 {
    public static void main(String[] args) {

    }

    static int longestOnes(int[] arr, int k) {
        int a = max_sub_Array(arr , k , 0);
        int b = max_sub_Array(arr , k , 1);
        return Math.max(a , b);
    }

    static int max_sub_Array(int[] arr , int k , int t){
        int s = 0;
        int e = 0;
        int flip = 0;
        int max = 0;
        while (e < arr.length){

//            GROW
            if(arr[e] == t){
                flip++;
            }
//            SHRINK
            while (flip > k){
                if(arr[s] == t){
                    flip--;
                }
                s++;
            }

//            WINDOW SIZE
            max = Math.max(max , e-s+1);
            e++;

        }
        return max;
    }
}
