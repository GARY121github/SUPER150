package STACKS_AND_QUEUE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Reverse_Queue {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1 ; i <= 5 ; i++){
            queue.add(10*i);
        }

        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }

    static void reverseQueue(Deque<Integer> queue){
        if(queue.isEmpty()){
            return;
        }

        int element = queue.remove();
        reverseQueue(queue);
        queue.add(element);
    }
}
