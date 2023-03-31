package Assignment_6;

import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element {
        public static void main(String[] args) {

            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();

            while (t > 0) {
                int n = scn.nextInt();
                int[] arr = new int[n];

                for (int i = 0; i < arr.length; i++)
                    arr[i] = scn.nextInt();

                nextLarger(arr);

                t--;
            }

        }

        // Function to print Next Greater Element for each element of the array
        public static void nextLarger(int[] nums2) {
            int[] ans = new int[nums2.length];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0 ; i < nums2.length ; i++){

                while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    int index = stack.pop();
                    ans[index] = nums2[i];
                }

                stack.push(i);
            }

            while(!stack.isEmpty()){
                int index = stack.pop();
                ans[index] = -1;
            }

            for(int i = 0 ; i < nums2.length ; i++){
                System.out.println(nums2[i] + "," + ans[i]);
            }

        }

}
