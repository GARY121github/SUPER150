package Recursion.Backtracking;

public class Place_queen_in_different_box {
    public static void main(String[] args) {
        boolean[] box = new boolean[4];
        int queen = 2;
        printCombinations(box , queen , 0 , 0 , "");
    }

    static void printCombinations(boolean[] board , int total , int current , int index ,  String ans){
        if(current == total){
            System.out.println(ans);
            return;
        }

        for (int i = index ; i < board.length ; i++){
            if(!board[i]){
                board[i] = true;
                printCombinations(board , total , current+1 , ++index , ans+" BOX "+ i + " QUEEN " + current);
                board[i] = false;
            }
        }
    }
}
