package Sliding_Window;

public class Minimum_Operations_to_Reduce_X_to_Zero_1658 {
    public static void main(String[] args) {

    }
    public int minOperations(int[] arr, int x) {
        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        int current = 0;
        while (e < arr.length){
//            GROW
            current += arr[e];

//            SHRINK
            while (current > x){
                current -= arr[s];
                s++;
            }

            if(current == x){
                int t = e-s+1;
                if(t < min){
                    min = t;
                }
            }

            e++;
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }

        return min;
    }
}
