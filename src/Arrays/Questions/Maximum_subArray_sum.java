package Arrays.Questions;

import java.util.Arrays;

public class Maximum_subArray_sum {
    public static void main(String[] args) {
        int[] arr = {1,2,-2,3,4};
        int[] ans = new int[2];
        ans = subArraySum(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] subArraySum(int[] arr){
        int s = 0;
        int e = 0;
        int c = 0;
        for(int i = 0 ; i < arr.length ; i++){
            c += arr[i];
            if(c <= 0){
                s = i + 1;
                c = 0;
            }
            e++;
        }
        return new int[]{s , e-1};
    }
}
