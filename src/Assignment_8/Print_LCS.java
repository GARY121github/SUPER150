package Assignment_8;

import java.util.Scanner;

/*
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of
the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after removal of elements
C, E and F.

Given two strings A and B of size n and m respectively, you have to print the Longest Common Subsequence(LCS) of strings A and B,
where LCS is the longest sequence present in both A and B.

Note: It is gauranteed that there is only one unique longest common subsequence

Input Format
Two strings A and B.

Constraints
1 <= n,m <= 10^3

Output Format
Output the LCS of A and B.

Sample Input
abc
acd
Sample Output
ac
*/
public class Print_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st1 = sc.next();
        String st2 = sc.next();
        lcs(st1 , 0 , st2 , 0 ,"");
        System.out.println(ans);
    }
    private static String ans = "";
    private static void lcs(String s1 , int i , String s2 , int j , String curr){
        if (i == s1.length() || j == s2.length()){
            if(curr.length() > ans.length()){
                ans = curr;
            }
            return;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            lcs(s1, i + 1, s2, j + 1, curr + s1.charAt(i));
        }
        else{
            lcs(s1 , i+1 , s2 , j , curr);
            lcs(s1 , i , s2 , j+1 , curr);
        }

    }
}
