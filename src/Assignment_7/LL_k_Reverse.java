package Assignment_7;

import java.util.Scanner;

/*
Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the
size of List.

You need not have to create a new list. Just reverse the old one using head.

Input Format
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Constraints
0 <= N <= 10^6 0 <= K <= 10^6

Output Format
Display the linkedlist after reversing every k elements

Sample Input
9 3
9 4 1 7 8 3 2 6 5
Sample Output
1 4 9 3 8 7 5 6 2
Explanation
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
*/
public class LL_k_Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        LL_k_Reverse ob = new LL_k_Reverse();
        for(int i = 1 ; i<= n ; i++){
            ob.add(sc.nextInt());
        }
//        ob.display();
        ob.Head = ob.reverseKGroup(ob.Head , k);
        ob.display();

    }

    void display(){
        ListNode temp = this.Head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode Head = null;
    private ListNode Tail = null;

    public void add(int data){
        if(this.Head == null){
            ListNode ob = new ListNode(data);
            this.Head = this.Tail = ob;
            return;
        }
        ListNode ob = new ListNode(data);
        this.Tail.next =  ob;
        this.Tail = this.Tail.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int s = 1;
        int e = k;

        int size = 1;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        while (e < size) {
            head = reverseBetween(head, s, e);

            s += k;
            e += k;
        }

        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseBetweenll(head, left, right);
    }

    static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // function used to reverse a linked list from position m to n
    static ListNode reverseBetweenll(ListNode head, int m, int n) {
        if (m == n)
            return head;

        // revs and revend is start and end respectively of the
        // portion of the linked list which need to be reversed.
        // revs_prev is previous of starting position and
        // revend_next is next of end of list to be reversed.
        ListNode revs = null, revs_prev = null;
        ListNode revend = null, revend_next = null;

        // Find values of above pointers.
        int i = 1;
        ListNode curr = head;
        while (curr != null && i <= n) {
            if (i < m)
                revs_prev = curr;
            if (i == m)
                revs = curr;
            if (i == n) {
                revend = curr;
                revend_next = curr.next;
            }
            curr = curr.next;
            i++;
        }
        revend.next = null;
        // Reverse linked list starting with revs.
        revend = reverse(revs);
        // If starting position was not head
        if (revs_prev != null)
            revs_prev.next = revend;
            // If starting position was head
        else
            head = revend;

        revs.next = revend_next;
        return head;
    }
}

