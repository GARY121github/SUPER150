package STACKS_AND_QUEUE;

import java.util.Arrays;

public class My_Stack {
    protected Object[] data;
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
       return size() == this.data.length;
    }

    public void push(Object data) throws Exception {
        if(isFull()) {
            throw new Exception("MY STACK IS FULL");
        }
        this.data[top] = data;
        top++;

    }

    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("MY STACK IS EMPTY");
        }
        top--;
        return this.data[top];
    }

    public Object peek() throws Exception {
        if(isEmpty()){
            throw new Exception("MY STACK IS EMPTY");
        }
        return this.data[top-1];
    }
    public int size(){
        return top;
    }

    void display(){
        System.out.println(Arrays.toString(this.data));
    }

    public static void main(String[] args) throws Exception {
        My_Stack stack = new My_Stack();


        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
//        stack.push(60);


        System.out.println(stack.pop());
    }
}
