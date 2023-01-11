package Recursion;

public class Reverse_String_344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        reverse(s , 0 , s.length-1);
    }

    static void reverse(char[] s , int start , int end){
        if(start > end){
            return;
        }

        char ch = s[start];
        s[start] = s[end];
        s[end] = ch;

        reverse(s , ++start , --end);
    }
}
