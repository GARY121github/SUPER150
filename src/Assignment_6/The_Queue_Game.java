package Assignment_6;

import java.io.*;

public class The_Queue_Game {
    public static void main (String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            int sum = 0;
            while(n-- > 0){
                int x = Integer.parseInt(br.readLine());
                if(x == 1){
                    sum += 1;
                }
                else{
                    sum -= 1;
                }

                if(sum < 0){
                    flag = flag;
                    break;
                }
            }
            if(flag){
                System.out.println("Valid");
            }
            else{
                System.out.println("Invalid");
            }
        }
    }
}
