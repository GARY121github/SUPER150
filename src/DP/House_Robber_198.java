package DP;

import java.util.Arrays;

public class House_Robber_198 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int[] dp = new int[arr.length];
        Arrays.fill(dp , -1);
    }

//    TOP DOWN -> Memoization
    private int robber(int[] arr , int i , int[] dp){
        if(i >= arr.length){
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

//        CHOOSE
        int choose = robber(arr , i+2 , dp) + arr[i];
//        NOT CHOOSE
        int not_choose = robber(arr , i+1 , dp);

        return dp[i] = Math.max(choose , not_choose);
    }

//    BOTTOM UP -> Tabulation
    private int robber(int[]     arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0] , arr[1]);
        for (int i = 2 ; i < arr.length ; i++){
            int choose = arr[i] + dp[i-2];
            int not_choose = dp[i-1];

            dp[i] = Math.max(choose , not_choose);
        }
        return dp[dp.length-1];
    }
}
