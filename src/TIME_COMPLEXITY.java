import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TIME_COMPLEXITY {
    public static void main (String[] args) throws java.lang.Exception
    {

    }

    static int minimumVisitedCells(int[][] grid) {
        int answer = ans(grid , 0 , 0 , 0);
        if(answer == Integer.MAX_VALUE){
            return -1;
        }

        return answer + 1;
    }

    static int ans(int[][] arr , int r , int c , int count){
        if(r == arr.length-1 && c == arr.length - 1){
            return count;
        }

        if(r >= arr.length || c >= arr[0].length || arr[r][c] == 0){
            return Integer.MAX_VALUE;
        }

        int answer = Integer.MAX_VALUE;

        int choices = arr[r][c] + c ;
        for(int k = c + 1 ; k <= choices ; k++){
            int total = ans(arr , r , c+k , count+1);
            answer = Math.min(total , answer);
        }

        choices = arr[r][c] + r ;
        for(int k = r + 1 ; k <= choices ; k++){
            int total = ans(arr , r+k, c , count+1);
            answer = Math.min(total , answer);
        }

        return answer;
    }
}
