package LinkedList;

public class Reverse_a_sublist_of_a_linked_list {
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Solution
{
    public static Node reverseBetween(Node head, int m, int n)
    {
        Node prev = null;
        Node start = null;
        Node end = null;
        Node after = null;

        Node current = head;
        for(int i = 1; current != null && i <= n ; i++){
            if(i < m){
                prev = current;
            }

            if(i == m){
                start = current;
            }

            if(i == n){
                end = current;
                after = end.next;
            }
            current = current.next;
        }

        end.next = null;

        Node starting_head = reverse(start);
        if(prev != null){
            prev.next = starting_head;
        }
        else{
            head = starting_head;
        }

        start.next = after;

        return head;
    }

    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        return prev;
    }
}
