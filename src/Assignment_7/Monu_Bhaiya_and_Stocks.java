package Assignment_7;

import java.util.Scanner;

/*
Monu bhaiya loves playing stocks.Help him with this game.
How many smooth descent periods are there in the daily price history of a given stock?
Given an integer array "prices" representing the daily price history of a stock, each element "prices[i]"
represents the stock price on the i-th day.
A smooth descent period of a stock is defined as a period of one or more contiguous days when the price on each day
is lower than the price on the preceding day by exactly 1. However, the first day of the period is exempted from this
rule.
As an investor, you are interested in identifying the smooth descent periods in the daily price history of a stock to
make informed investment decisions. Therefore, you want to know the total number of smooth descent periods in the given
price history.
Input Format
First Line:Consists of n i.e. size of the array
Second Line:Consists of n space separated integers
Constraints
1 <= prices.length <= 10^5
1 <= prices[i] <= 10^5
Output Format
Print the number of smooth descent periods.

Sample Input
4
3 2 1 4
Sample Output
7
Explanation
There are 7 smooth descent periods: [3], [2], [1], [4], [3,2], [2,1], and [3,2,1] Note that a period with one day is a smooth descent period by the definition.
*/
public class Monu_Bhaiya_and_Stocks {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int ans = smooth(arr);
        System.out.println(ans);
    }

    static int smooth(int[] arr){
        int s = 0;
        int e = 0;
        int count = 0;

        while(e < arr.length){
            if(e == s || arr[e]+1 == arr[e-1]){
                count += e-s+1;
                e++;
            }
            else{
                s = e;
            }
        }
        return count;
    }
}
