package Assignment_5;

import java.util.Scanner;

/*
Given an integer N, now you have to convert all zeros of N to 5.

Input Format
The first Line takes input integer N, denoting the number.

Constraints
1<=N<=10000

Output Format
Print the number after replacing all 0's with 5.

Sample Input
103
Sample Output
153
Explanation
Testcase 1: after replacing 0 with 5 ,number will become 153.
Testcase 2: there is no zero in number so it will remain same.
*/
public class Replace_all_0_with_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        replace(st , "");
    }
    static void replace(String st , String ans){
        if(st.isEmpty()){
            System.out.println(ans);
            return;
        }

        if(st.charAt(0) == '0'){
            replace(st.substring(1) , ans+'5');
        }else {
            replace(st.substring(1) , ans+st.charAt(0));
        }
    }
}
