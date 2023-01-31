package Assignment_5;

/*
Take as input str, a string.
a.) Write a recursive function which counts the number of times ‘hi’ appears in the string –
but skip all such ‘hi’ which are followed by ‘t’ to form ‘hit’. Print the value returned.
b.) Write a recursive function which removes all ‘hi’ in the string – but skip all such ‘hi’ which are followed
by ‘t’ to form ‘hit’. Print the value returned.
c.) Write a recursive function which replaces all ‘hi’ in the string with ‘bye’ – but skip all such ‘hi’
which are followed by ‘t’ to form ‘hit’. Print the value returned.
Input Format
Enter the String
Constraints
None
Output Format
Display the total no.of ''hi'' (''hi'' should not be followed by a 't'), string in which all ''hi'' are
removes(''hi'' should not be followed by a 't'), string in which all ''hi'' are
replace by ''bye''(''hi'' should not be followed by a 't')
Sample Input
abchihitfhi
Sample Output
2
abchitf
abcbyehitfbye
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Count_Remove_Replace_hi_Part_2 {
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
