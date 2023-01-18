package Recursion;

public class Grid_Matrix_to_reach_destination {
    public static void main(String[] args) {
        boolean[][] grid = {
                {true , true , true},
                {true , true , true},
                {true , true , true}
        };
        possible_Path(grid , 0 , 0 , "");
    }

    static void possible_Path(boolean[][] grid , int row , int col , String ans){
        if(row == grid.length-1 && col == grid[0].length-1){
            System.out.println(ans);
            return;
        }

        if(row < grid.length){
            possible_Path(grid , row+1 , col , ans+'D');
        }
        if(col < grid[0].length){
            possible_Path(grid , row , col+1 , ans+'R');
        }
    }
}
