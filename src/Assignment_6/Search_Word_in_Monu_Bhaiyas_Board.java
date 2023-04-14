package Assignment_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*

Monu Bhaiya has a board of size M x N consisting of characters and a list of strings words, print all words which
are on the board in a sorted order .

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once in a word.

Input Format
First Line contains 3 space-separated Integers M ,N and K(length of words list) .
Next M Lines contains strings of length N .
Next Line contains a list of words .

Constraints
1 <= N,M <= 12
1 <= word.length <= 104
1 <= word[i].length <= 10

Output Format
print space-separated words which are on the board.

Sample Input
4 4 5
oaan
etae
ihkr
iflv
oath pea eat rain fifa
Sample Output
eat oath
Explanation
There are only two words "oath" and "eat" from the list which are also in the character board .

*/
public class Search_Word_in_Monu_Bhaiyas_Board {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int word = sc.nextInt();
        char[][] board = new char[n][m];

        for(int i = 0 ; i < n ; i++){
            String st = sc.next();
            for(int j = 0 ; j < st.length() ; j++){
                board[i][j] = st.charAt(j);
            }
        }

        String[] words =new String[word];
        for (int i = 0 ; i < word ; i++){
            words[i] = sc.next();
        }

        List<String> ans = findWords(board , words);
        Collections.sort(ans);

        for (String i : ans){
            System.out.print(i + " ");
        }
    }
    static List<String> findWords(char[][] board, String[] words) {
        // Arrays.sort(words);
        List<String> list = new ArrayList<>();
        for(String word : words){
            char[][] arr = new char[board.length][board[0].length];

            for(int i = 0 ; i < board.length ; i++){
                for(int j = 0 ; j < board[0].length ; j++){
                    arr[i][j] = board[i][j];
                }
            }
            if(Exist(arr , word)){
                list.add(word);
            }
        }
        return list;
    }

    static boolean Exist(char[][] board, String word) {
        boolean[][] ans = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean a = search(board , i , j , word , 0 , ans);
                    if(a){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean search(char[][] board , int r , int c , String word , int index , boolean[][] ans){
        if(index == word.length()){
            return true;
        }

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || ans[r][c] || board[r][c] != word.charAt(index)){
            return false;
        }

        // board[r][c] = '*';
        ans[r][c] = true;

        int[] row = {1 , -1 , 0 , 0};
        int[] col = {0 , 0 , -1 , 1};

        for (int i = 0 ; i < row.length ; i++){
            boolean a = search(board , r+ row[i] , c + col[i] , word , index+1 , ans);
            if(a){
                return true;
            }
        }

        // board[r][c] = word.charAt(index);
        ans[r][c] = false;

        return false;
    }
}
