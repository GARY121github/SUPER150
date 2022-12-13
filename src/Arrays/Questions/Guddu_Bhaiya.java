package Arrays.Questions;

import java.util.Scanner;

public class Guddu_Bhaiya {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int q = sc.nextInt();
        StringBuilder builder = new StringBuilder(st);
        while(q-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            while(k-- > 0){
                char ch = builder.charAt(j-1);
                for(int p = j-1 ; p >= i ; p--){
                    builder.setCharAt( p , builder.charAt(p-1));
                }
                builder.setCharAt(i-1 , ch);
            }
        }
        System.out.println(builder);
    }
}
