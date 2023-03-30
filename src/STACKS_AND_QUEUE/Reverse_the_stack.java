package STACKS_AND_QUEUE;

import java.util.Stack;

public class Reverse_the_stack {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack);

        reverseStack(stack);

        System.out.println(stack);
    }

    static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int item = stack.pop();
        reverseStack(stack);
        putElementAtBottom(stack , item);
    }

    static void putElementAtBottom(Stack<Integer> stack , int item){
        if(stack.isEmpty()){
            stack.push(item);
            return;
        }

        int data = stack.pop();

        putElementAtBottom(stack , item);

        stack.push(data);
    }
}
