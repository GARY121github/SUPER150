package Assignment_4;

import java.util.Scanner;

/*

Mili has recently been assigned to get an old Art Gallery up and running.
She was looking around for improvements needed to be done and found out there a too few paintings and artifacts.
She wishes to add K more articles to the Gallery. However, for a better view, she wouldn’t place any two articles adjacently.
You are provided with an array A, of size N containing 0’s and 1’s representing the presence of an article the wall,
where 0 means the spot is empty and 1 means the spot already has an article. Will Mili be able to add K more article without
any two of them being placed adjacent.

Input Format
First line contains an integer N.
Second line contains N space-separated integers, 0’s and 1’s.
Third line contains K.

Constraints
1 <= N <= 10^5
0 <= K <= N
Ai = {0,1}

Output Format
Print “true” if it is possible to add K more articles, without any of them being adjacent, else print “false”.

Sample Input
5
1 0 0 0 1
1
Sample Output
true
Explanation
You can place the article at 3rd position without violating the adjacency.

*/
public class Mili_s_Gallery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Gallery(arr , k);
    }
    static void Gallery(int[] arr , int k){
        int count = 0;
        int ans = 0;
        int i = 0;
        int j = 0;
        while(j<arr.length && arr[j]==0){
            count++;
            j++;
        }
        if(count!=0&& count%2==0){
            count = count/2;
        }
        else{
            count = count/2;
        }
        ans += count;
        count = 0;
        i = j;
        while ( i < arr.length){
            if(arr[i] == 0){
                count++;
            }
            else {
                if(count!=0&& count%2==0){
                    count = count/2 -1;
                }
                else{
                    count = count/2;
                }
                ans += count;
                count = 0;
            }
            i++;
        }
        if(count!=0&& count%2==0){
            count = count/2;
        }
        else{
            count = count/2;
        }
        ans += count;
        count = 0;
        if(ans >= k){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
