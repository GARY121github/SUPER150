package Assignment_7;

import LinkedList.MyLinkedList;

import java.util.Scanner;

/*

Given a linked list with n nodes. Find the kth element from last without computing the length of the linked list.

Input Format
First line contains space separated integers representing the node values of the linked list. The list ends when the input comes as '-1'. The next line contains a single integer k.

Constraints
n < 10^5

Output Format
Output a single line containing the node value at the kth element from last.

Sample Input
1 2 3 4 5 6 -1
3
Sample Output
4
Explanation
The linked list is 1 2 3 4 5 6. -1 is not included in the list. So the third element from the last is 4

*/
public class Kth_element_from_last_in_linked_list {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        MyLinkedList list = new MyLinkedList();
        while (true){
            int x = sc.nextInt();
            if(x == -1){
                break;
            }

            list.addLast(x);
        }
        int k = sc.nextInt();

        System.out.println(list.getElement(list.getSize() - k));
    }

}
