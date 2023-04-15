package Assignment_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
You will be given a numeric string S. Print all the possible codes for S.

Following vector contains the codes corresponding to the digits mapped.

string table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

For example, string corresponding to 0 is " " and 1 is ".+@$"

Input Format
A single string containing numbers only.

Constraints
length of string <= 10

Output Format
All possible codes one per line in the following order.

The letter that appears first in the code should come first

Sample Input
12
Sample Output
.a
.b
.c
+a
+b
+c
@a
@b
@c
$a
$b
$c
Explanation
For code 1 the corresponding string is .+@$ and abc corresponds to code 2.
*/
public class Smart_Keypad_I {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String digit = sc.next();
        List<String> list = letterCombinations(digit);
        for(String i : list){
            System.out.println(i);
        }
    }

    static String key[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

    static List<String> letterCombinations(String digits) {
        List<String> list= new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        Phone(digits,"",list);
        return list;
    }
    public static void Phone(String digits, String ans, List<String> list){
        if(digits.length()==0){
            list.add(ans);
            return;
        }
        char ch=digits.charAt(0);
        String press= key[ch-'0'];
        for(int i=0;i<press.length();i++){
            Phone(digits.substring(1),ans+press.charAt(i),list);
        }
    }
}
