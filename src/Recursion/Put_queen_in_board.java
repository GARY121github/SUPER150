package Recursion;

import java.util.ArrayList;

public class Put_queen_in_board {
    public static void main(String[] args) {
        boolean[] box = new boolean[4];
        int queen = 2;
        Permutations(box , queen,  0 , "");
    }

    static void Permutations(boolean[] board , int total , int current , String ans){
        if(current == total){
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i < board.length ; i++){
            if(!board[i]){
                board[i] = true;
                Permutations(board , total , current+1 , ans+" POSITION " + i + " QUEEN " +current );
                board[i] = false;
            }
        }
    }
}
