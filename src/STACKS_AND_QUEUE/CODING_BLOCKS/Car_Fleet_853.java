package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Car_Fleet_853 {
    public static void main(String[] args) {

    }
    class Pair{
        int pos;
        int speed;
        public Pair(int pos , int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] arr = new Pair[speed.length];
        for(int i = 0 ; i < speed.length ; i++){
            arr[i] = new Pair(position[i] , speed[i]);
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.pos - o2.pos;
            }
        });

        Stack<Pair> stack = new Stack<>();
        for(int i = speed.length - 1 ; i >= 0 ; i--){
//            Pair pair = new Pair(position[i] , speed[i]);
            stack.push(arr[i]);

            if(stack.size() >= 2){
                Pair curr = stack.pop();
                double timeTaken_curr = (target - curr.pos) / (1.0 * curr.speed);
                Pair prev = stack.pop();
                double timeTaken_prev = (target - prev.pos) / (1.0 * prev.speed);

                if(timeTaken_curr <= timeTaken_prev){
                    System.out.println(curr.pos + " " + curr.speed + " " + timeTaken_curr);
                    System.out.println(prev.pos + " " + prev.speed + " " + timeTaken_prev);
                    stack.push(prev);
                }
                else{
                    stack.push(prev);
                    stack.push(curr);
                }
            }
        }

        return stack.size();
    }
}
