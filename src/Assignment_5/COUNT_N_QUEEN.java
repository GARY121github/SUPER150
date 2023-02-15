package Assignment_5;

import java.util.Scanner;
/*
You are given an empty chess board of size N*N. Find the number of ways to place N queens on the board, such that no
two queens can kill each other in one move. A queen can move vertically, horizontally and diagonally.

Input Format
A single integer N, denoting the size of chess board.

Constraints
1<=N<=11

Output Format
A single integer denoting the count of solutions.

Sample Input
4
Sample Output
2
*/
public class COUNT_N_QUEEN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] board = new boolean[n][n];
        System.out.println(placeQueens(board , n , 0));
    }

    static int placeQueens(boolean[][] arr , int queens , int row){
        if(queens == 0){
            System.out.println();
            return 1;
        }

        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(isValid(arr , row , i)){
                arr[row][i] = true;
                count += placeQueens(arr , queens-1 , row+1);
                arr[row][i] = false;
            }
        }

        return count;
    }
    static boolean isValid(boolean[][] board , int r , int c){
//        UPSIDE
        for(int u = r-1 ; u >= 0 ; u--){
            if(board[u][c]){
                return false;
            }
        }

//        LEFT DIGONAL
        for(int row = r-1 , col = c-1 ; row >=0 && col >= 0 ; row-- , col--){
            if(board[row][col]){
                return false;
            }
        }

//        RIGHT DIGONAL
        for(int row = r-1 , col = c+1 ; row >=0 && col < board.length ; row-- , col++){
            if(board[row][col]){
                return false;
            }
        }

        return true;
    }
}
