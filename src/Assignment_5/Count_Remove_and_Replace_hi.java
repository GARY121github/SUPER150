package Assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Take as input str, a string. a.Write a recursive function which counts the number of times ‘hi’ appears in the string.
Print the value returned. b.Write a recursive function which removes all ‘hi’ in the string. Print the value returned.
c.Write a recursive function which replaces all ‘hi’ in the string with ‘bye’. Print the value returned.

Input Format
Enter a string

Constraints
None

Output Format
Display the no. of 'hi', string without 'hi' , string in which 'hi' is replaced with 'bye'

Sample Input
abchibi
Sample Output
1
abcbi
abcbyebi
*/
public class Count_Remove_and_Replace_hi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        removehi(st , 0 , "");
        replacehi(st , "");
    }

    static void removehi(String st,  int count , String ans){
        if(st.isEmpty()){
            System.out.println(count);
            System.out.println(ans);
            return;
        }

        if(st.charAt(0) == 'h' && st.charAt(1) == 'i'){
            removehi(st.substring(2) , count+1 , ans);
        }else {
            removehi(st.substring(1) , count , ans+st.charAt(0));
        }
    }

    static void replacehi(String st, String ans){
        if(st.isEmpty()){
            System.out.println(ans);
            return;
        }

        if(st.charAt(0) == 'h' && st.charAt(1) == 'i'){
            replacehi(st.substring(2), ans+"bye");
        }else {
            replacehi(st.substring(1) , ans+st.charAt(0));
        }
    }
}
