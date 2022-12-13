package Arrays.Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
Alex wishes to meet two of his friends today. He is on a schedule, so he decided that after meeting one of his friends,
he would go to the other friend who lives exactly D units away.
You are given an array A, of size N where each element represents the location of his friends. Find the number of possible
ways he can visit any two of his friends such that he doesn’t visit the pair of locations more than once.

Input Format
First line contains an integer N.
Second line contains N space-separated integers.
Third line contains an integer D.

Constraints
1 <= N <= 105
|Ai| <= 109
0 <= D <= 109

Output Format
Single Integer, denoting the total number of possible ways for Alex’s visit.

Sample Input
5
1 2 3 4 5
1
Sample Output
4
Explanation
He can visit his friends at (1,2) or (2,3) or (3,4) or (4,5), i.e., 4 possible ways.
Note: Even though 2 of his friends live at 1, we only have to find a unique pair of locations. So, we won’t consider the
other (1,3) combination.
*/
public class Alex_on_a_Schedule {
        public static void main (String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            int distance = sc.nextInt();
            System.out.println(possible_Ways(arr , distance));
        }

        static int possible_Ways(int[] arr , int d){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0 ; i < arr.length ; i++){
                set.add(arr[i]);
            }
            arr = new int[set.size()];
            int p = 0;
            for(int i : set){
                arr[p++] = i;
            }

            int count = 0;

            Arrays.sort(arr);
            for(int i = 0 ; i < arr.length-1 ; i++){
                for(int j = 0 ; j < arr.length ; j++){
                    if(arr[j] - arr[i] == d){
                        count++;
                    }
                }
            }

            return count;
        }
}
