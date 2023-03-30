package STACKS_AND_QUEUE;

public class My_Queue {
    protected Object[] data;
    protected int front;
    private int size;

    public My_Queue(){
        this.data = new Object[5];
        this.front = 0;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public void Enqueue(Object data) throws Exception {
        if(isFull()){
            throw new Exception("MY QUEUE IS FULL");
        }

        int index = (this.front + this.size) % this.data.length ;

        this.data[index] = data;
        size++;
    }

    public Object Dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("MY QUEUE IS EMPTY");
        }
        Object data = this.data[front];

        this.front  = (this.front + 1) % this.data.length;
        this.size--;

        return data;
    }

    void Display(){
        int f = front;
        for (int i = 0 ; i < this.size ; i++){
            System.out.print(this.data[f] + " ");

            f = (f+1) % this.data.length;
        }
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) throws Exception {
        My_Queue queue = new My_Queue();
        queue.Enqueue(10);
        queue.Enqueue(10);
        queue.Enqueue(10);
        queue.Enqueue(10);
        queue.Enqueue(10);
        queue.Enqueue(10);
    }

}
