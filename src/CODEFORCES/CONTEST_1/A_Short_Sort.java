package CODEFORCES.CONTEST_1;

import java.util.Scanner;

public class A_Short_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            String str = sc.next();

            if(str.charAt(0) == 'a' || str.charAt(1) == 'b' || str.charAt(2) == 'c'){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
