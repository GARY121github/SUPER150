package LinkedList;

import java.util.LinkedList;

public class MyLinkedList {

//    NODE CLASS WHICH HOLDS DATA AND NEXT REFERENCE ADDRESS

    public class Node{
        int data;
        Node next;

//        CONSTRUCTOR TO INITIALISE DATA AND NEXT
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public Node Head;
    private int size;
    private Node Tail;


//                INSERTION PART
//    ADDING ELEMENT AT THE STARTING OF THE LINKED LIST
    public void addFirst(int data){
        Node ob = new Node(data);

        if(this.size == 0){
            this.Head = ob;
            this.Tail = ob;
            this.size++;
            return;
        }

        ob.next = this.Head;
        this.Head = ob;
        this.size++;
    }

//    ADDING ELEMENT AT THE ENDING OF THE LINKED LIST
    public void addLast(int data){
        Node ob = new Node(data);

        if(this.size == 0){
            this.Head = ob;
            this.Tail = ob;
            this.size++;
            return;
        }

        this.Tail.next = ob;
        this.Tail = ob;
        this.size++;
    }

//    ADD AT ANY INDEX
    public void add(int data , int index) throws Exception {
        if(index == 0){
            addFirst(data);
            return;
        } else if (index == this.size) {
            addLast(data);
            return;
        }

        Node ob = new Node(data);
        Node temp = GET(index-1);
        ob.next = temp.next;
        temp.next = ob;

        this.size++;

    }

//    GET THE KTH ELEMENT
    public int getElement(int k) throws Exception {
        return GET(k).data;
    }

    public Node getNode(int k) throws Exception {
        return GET(k);
    }

    private Node GET(int k) throws Exception {
        if(k < 0 || k >= this.size){
            throw new Exception("INVALID INDEX");
        }

        Node temp = this.Head;

        for(int i = 1 ; i <= k ; i++){
            temp = temp.next;
        }

        return temp;
    }

    public int getSize(){
        return this.size;
    }



    public void display(){
        Node temp = this.Head;

        for(int i = 0 ; i < this.size ; i++){
            System.out.print(temp.data  + "--->");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

//            DELETION PART

    public int deleteFirst() throws Exception {
        if(this.Head == null){
            throw new Exception("LINKED LIST IS EMPTY");
        }

        Node deletedNode = this.Head;
        this.Head = this.Head.next;
        this.size--;

        deletedNode.next = null;
        return deletedNode.data;
    }

    public int deleteLast() throws Exception {
        if(this.Head == null){
            throw new Exception("LINKED LIST IS EMPTY");
        }
        else if (this.size == 1){
            return deleteFirst();
        }
        Node deletedNode = this.Tail;
        this.Tail = GET(this.size-2);
        this.size--;

        deletedNode.next = null;
        return deletedNode.data;
    }

    public Node returnHead(){
        return this.Head;
    }

    public int delete(int index) throws Exception {
        if(index == 0){
            return deleteFirst();
        }

        if(index == this.size - 1){
            return deleteLast();
        }

        Node deleted_previous = GET(index-1);

        Node Deleted_index = deleted_previous.next;

        deleted_previous.next = Deleted_index.next;
        this.size--;

        if(this.size == 0){
            this.Head = this.Tail = null;
        }

        Deleted_index.next = null;
        return Deleted_index.data;
    }



}
