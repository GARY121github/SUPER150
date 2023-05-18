package Assignment_7;

import java.util.Scanner;

/*
Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of boards i.e.
if the length of a particular board is 5, it will take 5 units of time to paint the board. Compute the minimum amount of time to
paint all the boards.

Note that:

Every painter can paint only contiguous segments of boards.
A board can only be painted by 1 painter at maximum.
Input Format
First line contains K which is the number of painters. Second line contains N which indicates the number of boards.
Third line contains N space separated integers representing the length of each board.

Constraints
1 <= K <= 10
1 <= N <= 10
1<= Length of each Board <= 10^8

Output Format
Output the minimum time required to paint the board.

Sample Input
2
2
1 10
Sample Output
10
*/
public class Painters_Partition_Problem_Java {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minTime(arr , k));
    }
    static int minTime(int[] arr , int k){
        int s = 0;
        int e = 0;
        for(int i = 0 ; i < arr.length ; i++){
            e += arr[i];
        }

        int ans = 0;
        while(s <= e){
            int mid = s + (e-s)/2;

            if(isPossible(arr , k , mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] arr , int k , int max){
        int number_of_painters = 1;
        int painted = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(painted + arr[i] <= max){
                painted += arr[i];
            }
            else{
                i--;
                painted = 0;
                number_of_painters++;
            }

            if(number_of_painters > k){
                return false;
            }
        }
        return true;
    }
}
