package Assignment_5;

import java.util.Scanner;

/*
Replace all occurrences of pi with 3.14
Input Format
Integer N, no of lines with one string per line
Constraints
0 < N < 1000
0 <= len(str) < 1000
Output Format
Output result one per line
Sample Input
3
xpix
xabpixx3.15x
xpipippixx
Sample Output
x3.14x
xab3.14xx3.15x
x3.143.14p3.14xx
Explanation
All occurrences of pi have been replaced with "3.14".
*/
public class Replace_all_pi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            String st = sc.next();
            ans(st , "");
        }
    }

    static void ans(String st , String ans){
        if(st.isEmpty()){
            System.out.println(ans);
            return;
        }

        if(st.charAt(0) == 'p' && st.charAt(1) == 'i'){
            ans(st.substring(2) , ans+"3.14");
        }
        else {
            ans(st.substring(1) , ans+st.charAt(0));
        }
    }
}
