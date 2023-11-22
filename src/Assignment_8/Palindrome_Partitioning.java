package Assignment_8;

import java.util.Scanner;

/*
You are given a string. You need to partition that string such that each substrings after partitioning would be palindromic
string. You have to do this work with minimum number of partitioning.

Input Format
First line contains integer t which is number of test case. For each test case, it contains a string S.

Constraints
1<=t<=50
1<=S<=1000

Output Format
Print the minimum number of partitioning.

Sample Input
1
ababbbabbababa
Sample Output
3
Explanation
a|babbbab|b|ababa
*/
public class Palindrome_Partitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            String st = sc.next();
            int[] dp = new int[st.length()];
            System.out.println(palindromePartitioning(st , 0 , dp) - 1);
        }
    }

    private static int palindromePartitioning(String st , int index , int[] dp){
        if(index == st.length()){
            return 0;
        }

        if(dp[index] != 0){
            return dp[index];
        }

        int min = st.length();
        for (int i = index + 1 ; i <= st.length() ; i++){
            String curr = st.substring(index , i);
            if(isPalindrome(curr)){
                int c = palindromePartitioning(st , i , dp) + 1;
                if(c < min){
                    min = c;
                }
            }
        }

        return dp[index] = min;
    }

    private static boolean isPalindrome(String st){
        int s = 0;
        int e = st.length() - 1;
        while (s < e){
            if(st.charAt(s) != st.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
