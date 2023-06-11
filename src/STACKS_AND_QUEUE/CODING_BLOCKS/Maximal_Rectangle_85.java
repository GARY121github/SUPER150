package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Maximal_Rectangle_85 {
    public static void main(String[] args) {

    }
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int ans = 0;
        for(int i = matrix.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }
                else{
                    arr[j] += 1;
                }
            }
            int a = largestRectangleArea(arr);
            ans = Math.max(a , ans);
        }
        return ans;
    }

    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int h = arr[stack.pop()];
                int r = i;
                int area = 0;
                if(stack.isEmpty()){
                    area = h * r;
                }
                else{
                    int l = stack.peek();
                    area = h * (r - l - 1);
                }

                ans = Math.max(ans , area);
            }

            stack.push(i);
        }

        int r = arr.length;
        while(!stack.isEmpty()){
            int h = arr[stack.pop()];
            int area = 0;
            if(stack.isEmpty()){
                area = h * r;
            }
            else{
                int l = stack.peek();
                area = h * (r - l - 1);
            }

            ans = Math.max(ans , area);
        }

        return ans;
    }
}
