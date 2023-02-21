class LL {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
public class MyQueue extends LL{
    Node Front , Rear;

    public MyQueue(){
        Front = null;
        Rear = null;
    }

//    ENQUEUE
    void enqueue(int data){
        Node ob = new Node(data);

//        MY QUEUE IS EMPTY
        if(Front == null && Rear == null){
            Front = Rear = ob;
            return;
        }

        Rear.next = ob;
        Rear = ob;
    }

//    DEQUEUE
    int dequeue(){
//        UNDERFLOW
        if(Front == null){
            System.out.println("MY QUEUE IS EMPTY");
            return -1;
        }

        int data_to_be_deleted = Front.data;
        Front = Front.next;

        return data_to_be_deleted;
    }

//    OFFER GET FRONT
    int getFront(){
        if(Front == null){
            System.out.println("MY QUEUE IS EMPTY");
            return -1;
        }

        return Front.data;
    }

    public static void main(String[] args) {
        MyQueue ob = new MyQueue();

//        System.out.println(ob.Front.data);
//        System.out.println(ob.Rear.data);

        System.out.println();
        ob.enqueue(10);
        System.out.println(ob.Front.data);
        System.out.println(ob.Rear.data);
        System.out.println();
        ob.enqueue(20);
        System.out.println(ob.Front.data);
        System.out.println(ob.Rear.data);
        System.out.println();
        ob.enqueue(30);
        System.out.println(ob.Front.data);
        System.out.println(ob.Rear.data);
        System.out.println();
        ob.enqueue(40);
        System.out.println(ob.Front.data);
        System.out.println(ob.Rear.data);
        System.out.println();
        ob.enqueue(50);
        System.out.println(ob.Front.data);
        System.out.println(ob.Rear.data);
        System.out.println();

        while (ob.Front != null){
            System.out.print(ob.dequeue() + " -> ");
        }
        System.out.println("NULL");
    }
}

