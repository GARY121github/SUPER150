package CODEFORCES.CONTEST_1;

import java.util.Scanner;

public class D_1D_Eraser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String st = sc.next();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (st.charAt(i) == 'B') {
                    count++;
                    i += k-1;
                }
            }
            System.out.println(count);
        }
    }
}
