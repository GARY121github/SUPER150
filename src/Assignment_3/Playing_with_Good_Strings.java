package Assignment_3;

/*

A Good String is a string which contains only vowels (a,e,i,o,u) . Given a string S, print a single positive integer N
where N is the length of the longest substring of S that is also a Good String.

Note: The time limit for this problem is 1 second, so you need to be clever in how you compute the substrings.

Input Format
A string 'S'

Constraints
Length of string < 10^5

Output Format
A single positive integer N, where N is the length of the longest sub-string of S that is also a Good String.

Sample Input
cbaeicde
Sample Output
3
Explanation
The Longest good substring is "aei"



*/

import java.util.Scanner;

public class Playing_with_Good_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        goodString(st);
    }

    static void goodString(String st){
        int p1 = 0;
        boolean flag = false;
        int p2 = 0;
        int max_len = 0;
        int len_till_now = 0;
        while (p2 != st.length()){
            char ch = st.charAt(p2);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                if(!flag){
                    p1 = p2;
                    len_till_now = 1;
                }
                else {
                    len_till_now++;
                }

                if(max_len < len_till_now){
                    max_len = len_till_now;
                }
            }
        }
    }
}
