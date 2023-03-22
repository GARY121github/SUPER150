package STACKS_AND_QUEUE;

import java.util.Stack;

public class Find_the_element_at_the_bottom_of_the_stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ; i <= 5 ; i++){
            stack.push(10*i);
        }
        print(stack);
        System.out.println(stack);
    }

    static void print(Stack<Integer> stack){
        if(stack.size() == 1){
            System.out.println(stack.peek());
            return;
        }

        int element = stack.pop();
        print(stack);
        stack.push(element);
    }
}
