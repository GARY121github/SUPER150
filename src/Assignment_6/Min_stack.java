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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int push_count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next();
            if(arr[i].equals("push")){
                push_count++;
            }
        }
        int[] push_data = new int[push_count];
        for(int i = 0 ; i < push_count ; i++){
            push_data[i] = sc.nextInt();
        }

        solution min_stack = new solution();
        int p1 = 0;
        for(String i : arr){
            if(i.equals("push")){
                min_stack.push(push_data[p1++]);
            }
            else if(i.equals("pop")){
                min_stack.pop();
            } else if (i.equals("print")) {
                System.out.print(min_stack.getMin() + " ");
            } else if (i.equals("top")) {
                System.out.println(min_stack.top());
            }
        }
    }
}

class Pair{
    int data;
    int min;
    public  Pair(int data , int previous_min){
        this.data = data;
        if(data < previous_min){
            this.min = data;
        }
        else {
            this.min = previous_min;
        }
    }
}
class solution{
    static Stack<Pair> stack = new Stack<>();

    void push(int data){
        if(stack.isEmpty()){
            Pair ob = new Pair(data , Integer.MAX_VALUE);
            stack.push(ob);
            return;
        }

        Pair ob = new Pair(data , stack.peek().min);
        stack.push(ob);
    }
    int pop(){
        return stack.pop().data;
    }

    int getMin(){
        return stack.peek().min;
    }
    int top(){
        return stack.peek().data;
    }
}
