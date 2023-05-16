package Assignment_7;

import java.util.LinkedList;
import java.util.Scanner;

/*
Given 2 sorted linked lists , merge the two given sorted linked list and print the final Linked List.

Input Format
First Line contains T the number of test cases.
For each test case :
Line 1 : N1 the size of list 1
Line 2 : N1 elements for list 1
Line 3 : N2 the size of list 2
Line 4 : N2 elements for list 2

Constraints
1 <= T <= 1000
0<= N1, N2 <= 10^6
-10^7 <= Ai <= 10^7

Output Format
For each testcase , print the node data of merged linked list.

Sample Input
1
4
1 3 5 7
3
2 4 6
Sample Output
1 2 3 4 5 6 7
Explanation
The two lists after merging give the sorted output as [1,2,3,4,5,6,7] .
*/
public class Merge_Sorted_Linked_Lists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n1 = sc.nextInt();
            LinkedList<Integer> list1 = new LinkedList<>();
            for(int i = 0 ; i < n1 ; i++){
                list1.add(sc.nextInt());
            }
            int n2 = sc.nextInt();
            LinkedList<Integer> list2 = new LinkedList<>();
            for(int i = 0 ; i < n2 ; i++){
                list2.add(sc.nextInt());
            }
            mergeTwoSortedLinkedList(list1 , list2);
        }
    }

    static void mergeTwoSortedLinkedList(LinkedList<Integer> l1 , LinkedList<Integer> l2){
        LinkedList<Integer> ans = new LinkedList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()){
            if(l1.get(p1) < l2.get(p2)){
                ans.add(l1.get(p1++));
            }
            else{
                ans.add(l2.get(p2++));
            }
        }

        while(p1 < l1.size()){
            ans.add(l1.get(p1++));
        }

        while(p2 < l2.size()){
            ans.add(l2.get(p2++));
        }

        display(ans);
    }

    static void display(LinkedList<Integer> list){
        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
