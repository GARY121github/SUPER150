package Assignment_6;

import java.util.Scanner;
import java.util.Stack;

/*
We are given a circular array, print the next greater number for every element. If it is not found print -1 for that
number. To find the next greater number for element Ai , start from index i + 1 and go until the last index after which
we start looking for the greater number from the starting index of the array since array is circular.

Input Format
First line contains the length of the array n. Second line contains the n space separated integers.

Constraints
1 <= n <= 10^6
-10^8 <= Ai <= 10^8 , 0<= i< n

Output Format
Print n space separated integers each representing the next greater element.

Sample Input
3
1 2 3
Sample Output
2 3 -1
Explanation
Next greater element for 1 is 2,
for 2 is 3 but not present for 3 therefore -1
*/
public class Find_the_greater_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] ans = NGE_IN_ROTATED_ARRAY(arr);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    static int[] NGE_IN_ROTATED_ARRAY(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < 2*arr.length-1 ; i++){

//            REMOVE THE ELEMENTS SMALLER THAN CURRENT ELEMENT FROM THE STACK
            while (!stack.isEmpty() && arr[i % arr.length] > arr[stack.peek()]){
                ans[stack.peek()] = arr[i % arr.length];
                stack.pop();
            }

            if(i < arr.length){
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        return ans;
    }
}
