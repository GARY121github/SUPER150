package Assignment_4;

/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Input Format
First Line Contains 2 strings of length not more than 10^5

Constraints
1<=|S|<=10^5

Output Format
A single Line a containing String

Sample Input
ADOBECODEBANC ABC
Sample Output
BANC

 */

import java.util.Scanner;

public class Minimum_Window_Size_Substring {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String t = sc.next();
        System.out.println(MinimumWindow(st , t));
    }
    public static String MinimumWindow(String s, String t) {

        int[] frqt = new int[123];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            frqt[ch]++;
        }

        int[] frqs = new int[123];
        int si = 0;
        int ei = 0;
        int start = -1;
        int len = Integer.MAX_VALUE;
        int count = 0;
        while (ei < s.length()) {
            // grow
            char ch = s.charAt(ei);
            frqs[ch]++;
            if (frqt[ch] >= frqs[ch]) {
                count++;
            }
            // shrink
            if (count == t.length()) {
                //		char c = s.charAt(si);
                while (frqs[s.charAt(si)] > frqt[s.charAt(si)]&& si<=ei) {
                    frqs[s.charAt(si)]--;
                    si++;
                }

                // ans
                if (len > ei - si + 1) {
                    len = ei - si + 1;
                    start = si;
                }

            }

            ei++;

        }
        if (start == -1) {
            return "";
        }

        return s.substring(start, start + len);

    }
}
