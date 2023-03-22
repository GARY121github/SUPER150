package STACKS_AND_QUEUE;

import java.util.Stack;

public class Reverse_the_stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ; i <= 5 ; i++){
            stack.push(10*i);
        }
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int ele = stack.pop();
        reverse(stack);
        insertAtBottom(stack , ele);
    }
    static void insertAtBottom(Stack<Integer> stack , int element){
        if(stack.size() == 0){
            stack.push(element);
            return;
        }

        int ele = stack.pop();
        insertAtBottom(stack , element);
        stack.push(ele);
    }
}
