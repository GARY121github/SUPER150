package Assignment_6;

import java.io.*;

/*
The Game is as follows You have given a binary array, where 1 denotes push operation and 0 denotes a pop operation in
a queue. The task is to check if the possible set of operations are valid or not.
Print Valid if the set of Operations are Valid Otherwise Print Invalid.

Input Format
The First Line contains an Integer T, as the number of Test cases.
The Next Line contains an Integer N, as the Size of the Array.
The Next Line contains N Binary numbers separated by space.

Constraints
Output Format
Print Valid If the set of operations are valid Otherwise Print Invalid for each Test Case separated by a new Line.

Sample Input
2
5
1 1 0 0 1
5
1 1 0 0 0
Sample Output
Valid
Invalid
*/
public class The_Queue_Game {
    public static void main (String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            int sum = 0;
            while(n-- > 0){
                int x = Integer.parseInt(br.readLine());
                if(x == 1){
                    sum += 1;
                }
                else{
                    sum -= 1;
                }

                if(sum < 0){
                    flag = flag;
                    break;
                }
            }
            if(flag){
                System.out.println("Valid");
            }
            else{
                System.out.println("Invalid");
            }
        }
    }
}
