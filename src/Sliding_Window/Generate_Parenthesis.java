package Sliding_Window;

import java.util.Scanner;

/*
Given an integer 'n'. Print all the possible pairs of 'n' balanced parentheses.
The output strings should be printed in the sorted order considering '(' has higher value than ')'.

Input Format
Single line containing an integral value 'n'.

Constraints
1<=n<=11

Output Format
Print the balanced parentheses strings with every possible solution on new line.

Sample Input
2
Sample Output
()()
(())
*/
public class Generate_Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generate_valid_parenthesis(n , 0 , 0 , "");
    }

    static void generate_valid_parenthesis(int n , int o , int c , String ans){
        if(o == n && c == n){
            System.out.println(ans);
            return;
        }

        if(o < n){
            generate_valid_parenthesis(n , o+1 , c , ans+'(');
        }

        if(c < n && c < o){
            generate_valid_parenthesis(n , o , c+1 , ans+')');
        }
    }
}
