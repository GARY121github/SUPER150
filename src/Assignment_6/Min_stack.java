package Assignment_6;

import java.util.Scanner;
import java.util.Stack;

/*
Design a stack that supports push,pop,top,retrieving the minimum element in constant time.

Input Format
First line of input contains integer n denoting the size of the string array. Next line of input contains n space
separated string where i-th string represent i-th operation.(i.e, push,pop,top,getMin)

Constraints
Functions pop, top and getMin operations will always be called on non-empty stacks.

Output Format
Print the answer according to input operations.

Sample Input
7
push push push getMin pop top getMin
-2 0 -3
Sample Output
-3 0 -2
Explanation
push -2
push 0
push -3
print -3 (getMin)
pop -3
print 0 (top)
print -2 (getMin)
*/
public class Min_stack {

    private Stack<Pair> MinStack;

    public Min_stack(){
        MinStack = new Stack<>();
    }

    class Pair{
        int data;
        int min;
        public Pair(int data , int precious_min){
            this.data = data;
            if(data < precious_min){
                this.min = data;
            }
            else{
                this.min = precious_min;
            }
        }
    }

    void push(int data){
        if(MinStack.isEmpty()){
            Pair element = new Pair(data , data);
            MinStack.push(element);
            return;
        }

        Pair element = new Pair(data , MinStack.peek().min);
        MinStack.push(element);
    }

    int pop(){
        return MinStack.pop().data;
    }
    int getMin(){
        return MinStack.peek().min;
    }

    int top(){
        return MinStack.peek().data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] instructions = new String[n];
        int number_of_elements_to_be_pushed = 0;
        for(int i = 0 ; i < n ; i++){
            instructions[i] = sc.next();
            if(instructions[i].equals("push")){
                number_of_elements_to_be_pushed++;
            }
        }

        int[] elements_to_be_pushed = new int[number_of_elements_to_be_pushed];
        for(int i = 0 ; i < number_of_elements_to_be_pushed ; i++){
            elements_to_be_pushed[i] = sc.nextInt();
        }

        Min_stack stack = new Min_stack();
        int p = 0;
        for(String i : instructions){
            if(i.equals("push")){
                stack.push(elements_to_be_pushed[p++]);
            } else if (i.equals("pop")) {
                stack.pop();
            } else if (i.equals("getMin")) {
                System.out.print(stack.getMin() + " ");
            } else if (i.equals("top")) {
                System.out.print(stack.top() + " ");
            }
        }
    }
}
