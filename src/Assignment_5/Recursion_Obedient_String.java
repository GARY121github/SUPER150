package Assignment_5;

import java.util.Scanner;

/*
Take as input str, a string. Write a recursive function that checks if the string was generated using the following
rules and returns a Boolean value:
1. the string begins with an 'a'
2. each 'a' is followed by nothing or an 'a' or "bb"
3. each "bb" is followed by nothing or an 'a' Print the value returned.

Input Format
Enter the String

Constraints
None

Output Format
Display the boolean result

Sample Input
abba
Sample Output
true
*/
public class Recursion_Obedient_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        if(st.charAt(0) != 'a'){
            System.out.println(false);
        }else {
            System.out.println(check(st));
        }
    }

    static boolean check(String st){
        if(st.isEmpty()){
            return true;
        }

        char ch = st.charAt(0);

        if(ch == 'a'){
            if(st.length() == 1){
                return true;
            } else if (st.charAt(1) == 'a') {
                return check(st.substring(1));
            } else if(st.length() >= 3){
                String bb = st.substring(1 , 3);
                if(bb.equals("bb")){
                    return check(st.substring(1));
                }else {
                    return false;
                }
            }
        }
        else if(ch == 'b'){
            if(st.length() == 1){
                return false;
            }


            String str = st.substring(0,2);
            if(!str.equals("bb")){
                return false;
            } else if (st.length() == 2) {
                return true;
            } else {
                if(st.charAt(2) == 'a'){
                    return check(st.substring(2));
                }
                else if(st.length() >= 4){
                    String bb = st.substring(2 , 4);
                    if(str.equals(bb)){
                        return check(st.substring(2));
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}
