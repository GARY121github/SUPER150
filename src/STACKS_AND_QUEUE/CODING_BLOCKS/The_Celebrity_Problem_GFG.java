package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class The_Celebrity_Problem_GFG {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0},
                     {0, 0, 0},
                     {0, 1, 0}};
    }

    static int celebrity(int[][] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){
            stack.push(i);
        }

        while (stack.size() > 1){
            int i = stack.pop();
            int j = stack.pop();

            if(arr[i][j] == 1 && arr[j][i] == 0){
                stack.push(j);
            }
            else if (arr[i][j] == 0 && arr[j][i] == 1) {
                stack.push(i);
            }
        }
        if(stack.isEmpty()){
            return -1;
        }

        int index = stack.pop();
        for (int i = 0 ; i < arr.length ; i++){
            if(i == index){
                continue;
            }
            if(arr[i][index] == 0 || arr[index][i] == 1){
                return -1;
            }
        }
        return index;
    }
}
