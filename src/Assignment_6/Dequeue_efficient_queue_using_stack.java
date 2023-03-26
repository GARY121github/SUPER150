package Assignment_6;

import java.util.Scanner;
import java.util.Stack;

/*
Implement a Queue using two stacks Make it Dequeue efficient.

Input Format
Enter the size of the queue N add 0 - N-1 numbers in the queue

Constraints
Output Format
Display the numbers in the order they are dequeued and in a space separated manner

Sample Input
5
Sample Output
0 1 2 3 4
*/
public class Dequeue_efficient_queue_using_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue_Using_Two_Stack queue = new Queue_Using_Two_Stack();
        for(int i = 0 ; i < n ; i++){
            queue.Enqueue(i);
        }

        while (!queue.isEmpty()){
            System.out.print(queue.Dequeue() + " ");
        }
        System.out.println();
    }
}

class Queue_Using_Two_Stack{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue_Using_Two_Stack(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void Enqueue(int data){
        while (!stack1.isEmpty()){
            this.stack2.push(stack1.pop());
        }

        stack1.push(data);

        while (!stack2.isEmpty()){
            this.stack1.push(stack2.pop());
        }
    }

    public int Dequeue(){
        return stack1.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
}
