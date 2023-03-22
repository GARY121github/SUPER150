package Assignment_5;

import java.util.Scanner;

public class Mazepath_D_Count_Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        total_path(row , col , 0 , 0 , "");
        System.out.println();
        System.out.println(count);

        int ans = path(row ,  col , 0 , 0 , "");
        System.out.println();
        System.out.println(ans);
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

        if(cr+1 < row && cc + 1 < col){
            total_path(row , col , cr+1 , cc+1 , ans+"D");
        }
    }

    static int path(int row , int col , int r , int c , String ans){

        // BASE CONDITION
        if(r == row-1 && c == col-1){
            System.out.print(ans + " ");
            return 1;
        }

        // BASE CONDITION
        if(r == row || c == col){
            return 0;
        }

        int count = 0;

        // VERTICAL
        count += path(row , col , r , c+1 , ans+'V');

        // HORIZONTAL
        count += path(row , col , r+1 , c , ans+'H');

        // DIGONALLY
        count += path(row , col , r+1 , c+1 , ans+'D');

        return count;
    }
}
