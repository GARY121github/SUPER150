package CODEFORCES.CONTEST_1;

import java.util.Arrays;
import java.util.Scanner;

public class C_Target_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            char[][] arr = new char[10][10];
            for (int i = 0; i < 10; i++) {
                String st = sc.next();
                for (int j = 0; j < st.length(); j++) {
                    arr[i][j] = st.charAt(j);
                }
            }
//            for (char[] a : arr){
//                System.out.println(Arrays.toString(a));
//            }
            int totalScore = 0;
            for (int i = 1; i <= arr.length; i++) {
                for (int j = 1; j <= arr.length; j++) {
                    char ch = arr[i-1][j-1];
                    if (ch == 'X') {
//                        System.out.println(i + " " + j);

                        int first = 0;
                        int second = 0;
                        if(i <= 5){
                            first = i;
                        }
                        else{
                            first = 11 - i;
                        }

                        if(j <= 5){
                            second = j;
                        }
                        else {
                            second = 11 - j;
                        }

                        totalScore += Math.min(first , second);
//                        System.out.println(totalScore);
                    }
                }
            }

            System.out.println(totalScore);
        }
    }
}
