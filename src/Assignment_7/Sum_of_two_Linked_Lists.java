package Assignment_7;

import LinkedList.MyLinkedList;

import java.util.Scanner;

/*

Given two numbers represented by two linked lists, write a program that prints the sum list. The sum list is linked list representation
of addition of two input numbers in linked lists. It is not allowed to modify the lists. Also, not allowed to use explicit extra space
(Use Recursion).

Input Format
First line contains N,M, number of nodes in the 1st and 2nd list.
Next line contains N nodes of 1st list.
Next line contains M nodes of 2nd list.

Constraints
0<N<10^6

Output Format
Print the sum list after adding the two linked lists.

Sample Input
3 3
5 6 3
8 4 2
Sample Output
1 4 0 5
Explanation
After adding the two numbers represented by linked lists i.e. 563 + 842 =1405 is represented as sum list. Sum list =1 -> 4 -> 0 -> 5.

*/
public class Sum_of_two_Linked_Lists {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();

        for(int i = 0 ; i < p1 ; i++){
            list1.addLast(sc.nextInt());
        }

        for(int i = 0 ; i < p2 ; i++){
            list2.addLast(sc.nextInt());
        }

        p1 = list1.getSize() - 1;
        p2 = list2.getSize() - 1;
        MyLinkedList ans = new MyLinkedList();
        int carry = 0;
        while (p1 >= 0 && p2 >= 0){
            int sum = list1.getElement(p1) + list2.getElement(p2) + carry;

            ans.addFirst(sum % 10);
            carry = sum / 10;

            p1--;
            p2--;
        }

        while (p1 >= 0){
            int sum = list1.getElement(p1) + carry;

            ans.addFirst(sum % 10);
            carry = sum / 10;

            p1--;
        }

        while (p2 >= 0){
            int sum = list2.getElement(p2) + carry;

            ans.addFirst(sum % 10);
            carry = sum / 10;

            p2--;
        }

        if(carry != 0){
            ans.addFirst(carry);
        }

        ans.display();
    }
}
