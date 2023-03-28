package STACKS_AND_QUEUE;

public class My_Queue {
    private Object[] data;
    private int front;
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
//        this.size--;
//        return this.data[this.front++];

        Object data = this.data[front];

        this.front  = (this.front + 1) % this.data.length;
        this.size--;

        return data;
    }

    public int size(){
        return this.size;
    }
}
