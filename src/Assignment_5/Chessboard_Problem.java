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
        int n = 3;
        System.out.println(allPossibleMoves(n , 0 , 0 , "" , 0));
    }

    static int allPossibleMoves(int n , int row , int col , String ans , int count){
        if(row == n-1 && col == n-1){
            System.out.println(ans);
            return 1;
        }

        if(row+2 < n && col+1 < n){
            count += allPossibleMoves(n , row+2 , col+1 , ans+"KD->" , count);
        }

        if(row+1 < n && col+2 < n){
            count += allPossibleMoves(n , row+1 , col+2 , ans+"KR->" , count);
        }

        if(col != n-1){
            count += allPossibleMoves(n , row , col+1 , ans+"RCO->" , count);
            count += allPossibleMoves(n , row , n-1 , ans+"RCF->" , count);
        }

        if(row != n-1){
            count += allPossibleMoves(n , row+1 , col , ans+"RRO->" , count);
            count += allPossibleMoves(n , n-1 , col , ans+"RRF->" , count);
        }

        if(row == col){
            count += allPossibleMoves(n , row+1 , col+1 , ans+"B0->" , count);
            count += allPossibleMoves(n , n-1 , n-1 , ans+"BF->" ,count);
        }

        return count;
    }
}
