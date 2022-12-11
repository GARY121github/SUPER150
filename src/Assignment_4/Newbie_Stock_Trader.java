package Assignment_4;

/*

The prices of a given stock on a day is given in the form of an array A, of size N. Where Ai is the price of the stock on ith day.
Monu has just started trading in stocks and so he relies on one of his friends for advice.
His friend, for some reason, advises him to trade only on days where the price of the stock keeps rising every day.
Would you be able to find the maximum number of continuous days where Monu can trade as per his friend’s advice?
Note: The price must rise daily for Monu to trade.

Input Format
First line contains an integer N.
Second line contains N space-separated integers.

Constraints
1 <= N <= 10^5
|Ai| <= 10^9

Output Format
Single Integer, denoting the maximum number of days where Vivek can trade.

Sample Input
5
1 4 7 5 9
Sample Output
3
Explanation
Monu can trade on the first three days as the price, 1 < 4 < 7.
Note: 1 < 4 < 7 < 9 isn’t a viable option as the days aren’t continuous.

*/

import java.util.Scanner;

public class Newbie_Stock_Trader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumNumberOfDays(arr));
    }

    static int maximumNumberOfDays(int[] arr){
//        int max_days = 0;
//        int current_max = 1;
//        for(int i = 1 ; i < arr.length ; i++){
//            if(arr[i] > arr[i-1]){
//                current_max++;
//            }
//            else {
//                current_max = 1;
//            }
//
//            if(current_max > max_days){
//                max_days =  current_max;
//            }
//        }
//        return max_days;

        int n = arr.length;
        int max=1;
        int len = 1;
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1])
                len++;
            else{
                max=Math.max(max, len);
                len=1;
            }
        }
        max=Math.max(max, len);
        return max;
    }


}
