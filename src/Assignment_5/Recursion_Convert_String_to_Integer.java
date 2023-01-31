package Assignment_5;

import java.util.Scanner;

/*
Take as input str, a number in form of a string. Write a recursive function to convert the number in string form to
number in integer form. E.g. for “1234” return 1234. Print the value returned.
Input Format
Enter a number in form of a String
Constraints
1 <= Length of String <= 10
Output Format
Print the number after converting it into integer
Sample Input
1234
Sample Output
1234
Explanation
Convert the string to int. Do not use any inbuilt functions.
*/
public class Recursion_Convert_String_to_Integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        System.out.println(convert_Into_Integer(st , 0));
    }

    static int convert_Into_Integer(String st , int ans){
        if(st.isEmpty()){
            return ans;
        }
        return convert_Into_Integer(st.substring(1) , ans*10 + (st.charAt(0)-48));
    }
}
