package Assignment_5;

/*
Take as input N, a number. N represents the size of a chess board. We’ve a piece standing in top-left corner and it
must reach the bottom-right corner. The piece moves as follows –

a. In any cell, the piece moves like a knight. But out of the possible 8 moves for a knight, only the positive ones are
valid i.e. both row and column must increase in a move.

b. On the walls (4 possible walls), the piece can move like a rook as well (in addition of knight moves). But, only the
positive moves are allowed i.e. as a rook, piece can move any number of steps horizontally or vertically but in a
manner, such that row or column must increase.

c. On the diagonals (2 possible diagonals), the piece can move like a bishop as well (in addition to the knight and
possibly rook moves). But, only the positive moves are allowed i.e. as a bishop, piece can move in a way such that row
and column must increase.

You are supposed to write the following functions

a. Write a recursive function which prints all valid paths.

b. Write a recursive function which returns the count of different distinct ways this board can be crossed. Print
the value returned.

Input Format
Enter the size of the chessboard N

Constraints
None

Output Format
Display the total number of valid paths and print all the valid paths in a space separated manner

Sample Input
3
Sample Output
{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-1}K{2-2} {0-0}R{0-1}R{0-2}R{1-2}R{2-2} {0-0}R{0-1}R{0-2}R{2-2}
{0-0}R{0-1}R{1-1}B{2-2} {0-0}R{0-1}R{2-1}R{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2}
{0-0}R{1-0}R{1-1}B{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2}
{0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{1-1}B{2-2} {0-0}B{2-2}
18
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Chessboard_Problem {
    public static void main(String[] args) {
        int n = 2;
        allPaths(n , 0 , 0 , "");
        System.out.println(list.size());
    }

    static ArrayList<String> list = new ArrayList<>();

    static void allPaths(int n , int row , int col , String ans){
        if(row == n && col == n){
            System.out.println(ans + '{' + row + '-' + col + '}' );
            list.add(ans);
            return;
        }

//        KD
        if(row+2 <= n && col <= n)
            allPaths(n , row+2 , col+1 , ans+'{' + row + '-' + col + '}' + "KD->");
//        KR
        if(row+1 <= n && col+2 <= n)
            allPaths(n , row+1 , col+2 , ans+'{' + row + '-' + col + '}' +"KR->");

//        RR
        if(col+1 <= n)
            allPaths(n , row , col+1 , ans+'{' + row + '-' + col + '}' +"RR->");
//        DRR
        if(col + n <= n)
            allPaths(n , row , n , ans+'{' + row + '-' + col + '}' +"DRR->");

//        RD
        if(row+1 <= n)
            allPaths(n , row+1 , col , ans+'{' + row + '-' + col + '}' +"RD->" );

//        BO
        if(row==col)
            allPaths(n , row+1 , col+1 , ans+'{' + row + '-' + col + '}' +"BO->");
//        BD
        if(row==col && row+n <= n && col+n <= n)
            allPaths(n,  n , n ,ans+'{' + row + '-' + col + '}' +"BD");
        //        DRD
        if(row+n <= n)
            allPaths(n , n , col, ans+'{' + row + '-' + col + '}' +"DRD->");


    }
}
