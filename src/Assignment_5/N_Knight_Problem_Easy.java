package Assignment_5;

import java.util.Scanner;

/*
Take as input N, the size of a chess board. We are asked to place N number of Knights in it, so that no knight can
kill other.
a. Write a recursive function which returns the count of different distinct ways the knights can be placed across the
board. Print the value returned.
b.Write a recursive function which prints all valid configurations (void is the return type for function).
Input Format
Enter the size of the chessboard N
Constraints
None
Output Format
Display the number of ways a knight can be placed and print all the possible arrangements in a space separated manner
Sample Input
2
Sample Output
{0-0} {0-1}  {0-0} {1-0}  {0-0} {1-1}  {0-1} {1-0}  {0-1} {1-1}  {1-0} {1-1}
6
*/
public class N_Knight_Problem_Easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] board = new boolean[n][n];
        int ans = placeKnights(board , n , "" , 0 , 0 );
        System.out.println();
        System.out.println(ans);
    }

    static int placeKnights(boolean[][] board , int Knights , String ans , int row , int col){
        if(Knights == 0){
            System.out.print(ans + " ");
            return 1;
        }

        if(col == board.length)
        {
            row = row+1;
            col = 0;
        }
        if(row == board.length){
            return 0;
        }
        int count = 0;

//        CHOOSE
        if(isSafe(board , row , col)){
            board[row][col] = true;
            count += placeKnights(board , Knights-1 , ans+'{'+row+'-'+col+"} " , row , col+1);
            board[row][col] = false;
        }
//        NOT CHOOSE
        count += placeKnights(board , Knights , ans , row , col+1);

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
//        UPWARDS - LEFT
        if(row-2 >= 0 && col - 1 >= 0){
            if(board[row-2][col-1]){
                return false;
            }
        }

//        UPWARDS - RIGHT
        if(row-2 >= 0 && col + 1 < board.length){
            if(board[row-2][col+1]){
                return false;
            }
        }

//        LEFTWARDS - UP
        if(row-1 >= 0 && col - 2 >= 0){
            if(board[row-1][col-2]){
                return false;
            }
        }

//        RIGHTWARDS - UP
        if(row-1 >= 0 && col + 2 < board.length){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }
}
