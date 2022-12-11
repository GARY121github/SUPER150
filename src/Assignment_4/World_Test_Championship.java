package Assignment_4;

/*

BCCI Announced Test squad last Month for the tour of England as the team will play the WTC final against New Zealand
in June as well as five Test matches against England in August-September, India and New Zealand are the top two teams, and
now they have to play the World Test Championship (WTC) final test match and the winning team will lift the inaugural
World Test Championship (WTC) trophy.

Rohit Sharma also known as Hitman Sharma and vice captain of Indian Cricket Team decided that he will play very aggressively
and will hit maximum time sixes or fours. Also taking singles and doubles India won the match with ease because of
Hitman Sharma's efforts.


But due to some technical issues, the records of his boundaries and singles and doubles got lost . Now Cricinfo,
which maintains the records for each player, wants to hire you as a developer if you are able to resolve this problem and give
them the exact count of runs in every over.

Cricinfo will give you an array of N overs, containing runs made in each over.

For making your task easy, maximize the contiguous number of overs such that in every over different runs were made.

If you are able to complete this task successfully, then congratulations you are hired.

Input Format
First Line Contains N Which denotes Number of over
second Line contains N number which denotes run made in each overs

Constraints
N<10^5

Output Format
Maximize the contiguous number of overs such that in every over different runs were made.

Sample Input
6
4 3 4 3 5 6
Sample Output
4
Explanation
Over no 3 to over 6 (i.e. values 4 3 5 6) different runs were made.

*/

import java.util.HashMap;
import java.util.Scanner;

public class World_Test_Championship {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // int result = LargestSubarray(arr, n);

        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            j = Math.max(hmap.containsKey(arr[i]) ? hmap.get(arr[i]) : 0, j);
            ans = Math.max(ans, i - j + 1);
            hmap.put(arr[i], i + 1);
        }

        // to many complex thing
        System.out.println(ans);
    }
}
