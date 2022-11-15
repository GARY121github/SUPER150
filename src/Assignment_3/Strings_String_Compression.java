package Assignment_3;

/*
Take as input S, a string. Write a function that does basic string compression. Print the value returned.
E.g. for input “aaabbccds” print out a3b2c2ds.

Input Format
A single String S.

Constraints
A string of length between 1 to 1000

Output Format
The compressed String.

Sample Input
aaabbccds
Sample Output
a3b2c2ds
Explanation
In the given sample test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c' is repeated twice.
But, 'd' and 's' occurred only once that's why we do not write their occurrence.
*/

import java.util.Scanner;

public class Strings_String_Compression {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        compressedString(st);
    }

    static void compressedString(String st){
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(p2 < st.length()){
            if(st.charAt(p1) != st.charAt(p2)){
                System.out.print(st.charAt(p1));
                if(count > 1)
                    System.out.print(count);

                count = 0;
                p1 = p2;
            }
            else{
                p2++;
                count++;
            }
        }
        count = 0;
        for(int i = p1 ; i < st.length() ; i++){
            if(st.charAt(p1) == st.charAt(i)){
                count++;
            }
        }
        System.out.print(st.charAt(p1));
        if(count>1)
            System.out.print(count);
    }
}
