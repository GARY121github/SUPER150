package Assignment_7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

Input Format
First line contains size of the array.
Second line contains the elements of the array.

Constraints
1 <= Size of array <= 100000

Output Format
Print the leaders in increasing order.

Sample Input
4
5 7 10 6
Sample Output
6 10
*/
public class Leaders_in_an_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        leaders(arr);
    }

    static void leaders(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[arr.length - 1]);
        for (int i = arr.length - 2 ; i >= 0 ; i--){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
            }
        }

        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
