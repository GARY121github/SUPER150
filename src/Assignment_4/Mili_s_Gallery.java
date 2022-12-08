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
        int i = 0;


//        EDGE TEST CASES
        if(arr.length == 1){
            if(arr[0] == 0){
                count++;
            }

            if(count >= k)
                System.out.println("true");
            else
                System.out.println("false");

            return;

        }

        while (i < arr.length){

            boolean flag = true;
//            FOR FIRST POSITION
            if(i == 0){
                if(arr[i] == 0 && arr[i+1] == 0){
                    count++;
                    arr[i] = 1;

                    i = i+2;

                    flag = false;
                }
            }

//            MID POSITIONS
            if(arr[i] == 0 && arr[i-1] != 1 && arr[i+1] != 1){
                count++;
                arr[i] = 1;

                i = i+2;
                flag = false;
            }

//            LAST POSITION
            if(i ==arr.length-1){
                if(arr[i-1] != 1){
                    count++;
                    arr[i] = 1;

                }
            }

            if(flag){
                i = i+1;
            }
        }

        if(count >= k)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
