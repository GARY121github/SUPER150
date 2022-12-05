package Assignment_4;


/*

Monu Bhaiya is hosting a party. He invites N of his/her students to his house and pairs them up.
Each of his students has some Perance, representing his/her performance at Coding Blocks.
The charm of his party is represented by the sum of minimum Perance from each pair in the party.
You are given an array A, of N elements, where Ai is the Perance of a student at his party.
Help him get the maximum charm for his party and output it.
Given: N is even.

Input Format
First line contains an integer N.
Second line contains N space-separated integers, representing the Perance of a student.

Constraints
1 <= N <= 10^4
|Ai| <= 10^4

Output Format
Single Integer representing the maximum possible charm.

Sample Input
4
1 3 4 2
Sample Output
4
Explanation
Possible pairings are:
(1,3),(4,2) -> min(1,3) + min(4,2) = 1+2 = 3
(1,4),(3,2) -> min(1,4) + min(3,2) = 1+2 = 3
(1,2),(4,3) -> min(1,2) + min(4,3) = 1+3 = 4
(Ordering of the pairs doesn’t matter)


*/

import java.util.Arrays;
import java.util.Scanner;

public class Perance_Party {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(Party(arr));
    }

    static int Party(int[] arr){

        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0 ; i < arr.length ; i = i+2){
            ans += Math.min(arr[i],arr[i+1]);
        }

        return ans;
    }
}
