package Sliding_Window;
/*
Take as input N, a number. N is the size of a snakes and ladder board (without any snakes and ladders).
Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the board can be traveled using the dice.
Print the value returned.

b. Write a recursive function which prints dice-values for all valid paths across the board (void is the return type
for function).

Input Format
Enter a number N (size of the board) and number M(number of the faces of a dice)

Constraints
None

Output Format
Display the number of paths and print all the paths in a space separated manner

Sample Input
3
3
Sample Output
111 12 21 3
4
*/

import java.util.Scanner;

public class Boardpath_Count_Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int faces = sc.nextInt();

        int t = paths(n , faces , 1 , 0 , 0 , "");
        System.out.println();
        System.out.println(t);
    }

    static int paths(int n , int faces , int move , int sum , int count, String ans){
        if(sum == n){
            count++;
            System.out.print(ans + " ");
            return count;
        }

        if(sum > n){
            return count;
        }

        for(int i = 1 ; i <= faces ; i++){
            count = paths(n , faces , i , sum+i , count , ans+i);
        }

        return count;
    }
}
