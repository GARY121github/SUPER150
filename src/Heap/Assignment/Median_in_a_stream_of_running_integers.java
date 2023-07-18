package Heap.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
You are given a running data stream of n integers. You read all integers from that running data stream and find effective
median of elements read so far in efficient way. All numbers are unique in the data-stream. Print only the integer part of the median.

Input Format
First line contains integer t as number of test cases. Each test case contains following input. First line contains integer n
which represents the length of the data stream and next line contains n space separated integers.

Constraints
1 < t < 100
1< n < 10000

Output Format
Print the effective median of running data stream..

Sample Input
1
6
5 15 1 3 2 8
Sample Output
5 10 5 4 3 4
Explanation
Iteration 1 : Array = {5} Median = 5

Iteration 2 : Array = {5,15} Median = (5+15)/2 = 10

Iteration 3 : Array = {1,5,15} Median = 5

Iteration 4 : Array = {1,3,5,15} Median = (3+5)/2 = 4
Iteration 5 : Array = {1,2,3,5,15} Median = 3
Iteration 6 : Array = {1,2,3,5,8,15} Median = (3+5)/2 = 4
*/
public class Median_in_a_stream_of_running_integers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0 ; i < n ; i++){
                int x = sc.nextInt();
                list.add(x);
                Collections.sort(list);
                if(list.size()%2 == 0){
                    int m = list.size() / 2;
                    System.out.print((list.get(m) + list.get(m-1))/2 + " ");
                }
                else{
                    int m = list.size()/2 ;
                    System.out.print(list.get(m) + " ");
                }
            }
            System.out.println();
        }
    }
}
