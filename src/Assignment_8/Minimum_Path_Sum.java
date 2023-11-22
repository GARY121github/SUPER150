package Assignment_8;

import java.util.Scanner;

/*
Josh is stuck in a m*n grid. He has to travel from top left to bottom right.For every cell to pass, there is a specific
amount of money josh has to pay. Your task is to find out minimum amount of money josh has to pay to reach bottom right.

Input Format
First line contains two space separated integers m and n i.e number of rows and columns of grid. m lines follow each
containing n integers, denoting the cost of which josh has to pay to pass through that cell.

Constraints
None

Output Format
A single integer denoting minimum cost josh has to pay.

Sample Input
3 3
1 3 1
1 5 1
4 2 1
Sample Output
7
Explanation
Josh will take 1→3→1→1→1 path to minimize the amount he has to pay
*/
public class Minimum_Path_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPath(board , 0 , 0));
    }

    private static int minPath(int[][] board , int r , int c){
        if(r == board.length-1 && c == board[0].length - 1){
            return board[r][c];
        }

        if(r >= board.length || c >= board[0].length){
            return 1000000;
        }

        int right = minPath(board , r , c+1);
        int down = minPath(board , r+1, c);

        return Math.min(right , down) + board[r][c];
    }
}
