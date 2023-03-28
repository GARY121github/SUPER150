package STACKS_AND_QUEUE;

import java.util.Arrays;

public class My_Stack {
    private final Object[] data;
    private int top;

    public My_Stack(){
        this.data = new Object[5];
        this.top = 0;
    }

    public My_Stack(int capacity){
        this.data = new Object[capacity];
        this.top = 0;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == this.data.length;
    }

    public void push(Object data) throws Exception {
        if(isFull()){
            throw new Exception("MY STACK IS FULL");
        }

        this.data[top] = data;

        top++;
    }

    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("MY STACK IS EMPTY");
        }

        return this.data[top--];
    }

    public int sie(){
        return top;
    }
}
