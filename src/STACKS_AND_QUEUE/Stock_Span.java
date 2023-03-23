package STACKS_AND_QUEUE;

import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        arr = calculateSpan(arr , n);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("END");

    }
    public static int[] calculateSpan(int price[], int n)
    {
        int[] ans = new int[price.length];
        Stack<Integer> st = new Stack<>();

        for(int i =0 ; i < ans.length ; i++){

            while(!st.isEmpty() && price[i] >= price[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = i+1;
            }
            else{
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
