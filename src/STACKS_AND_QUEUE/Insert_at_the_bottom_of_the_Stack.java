package STACKS_AND_QUEUE;

import java.util.Stack;

public class Insert_at_the_bottom_of_the_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ; i <= 5 ; i++){
            stack.push(10*i);
        }
        insertAtBottom(stack , -7);
        System.out.println(stack);
    }

    static void insertAtBottom(Stack<Integer> stack , int element){
        if(stack.size() == 0){
            stack.push(element);
            return;
        }

        int ele = stack.pop();
        insertAtBottom(stack , element);
        stack.push(element);
    }
}
