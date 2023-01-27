package Assignment_5;

import java.util.Scanner;

/*
Take as input N1 and N2, both numbers. N1 and N2 is the number of rows and columns on a rectangular board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down).

a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

b. Write a recursive function which returns an ArrayList of moves for all valid paths across the board. Print the value returned.

e.g. for a board of size 3,3; a few valid paths will be “HHVV”, “VVHH”, “VHHV” etc. c. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).

Input Format
Enter the number of rows N and columns M

Constraints
None

Output Format
Display the total number of paths and display all the possible paths in a space separated manner

Sample Input
3
3
Sample Output
VVHH VHVH VHHV HVVH HVHV HHVV
6
*/
public class Maze_path__Count__Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        total_path(row , col , 0 , 0 , "");
        System.out.println();
        System.out.println(count);
    }

    static int count = 0;
    static void total_path(int row , int col , int cr , int cc , String ans){
        if(cr == row-1 && cc == col-1){
            System.out.print(ans + " ");
            count++;
            return;
        }

        if(cr < row){
            total_path(row , col , cr+1 , cc , ans+'V');
        }

        if(cc < col){
            total_path(row , col , cr , cc+1 , ans+"H" );
        }
    }
}
