package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Maximum_Score_of_a_Good_Subarray_1793 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,7,4,5};
        int k = 3;
//        Output: 15
    }

    static int maxScoreOfAGoodSubarray(int[] arr , int k){
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int r = i;
                int h = arr[stack.pop()];
                if(r-1 >= k){
                    if(!stack.isEmpty()){
                        int l = stack.peek();
                        if(l+1 <= k){
                            int current_Area = h * (r - l - 1);
                            area = Math.max(area , current_Area);
                        }
                    }
                    else{
                        int current_Area = h * r;
                        area = Math.max(area , current_Area);
                    }
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int r = arr.length;
            int h = arr[stack.pop()];
            if(r-1 >= k){
                if(!stack.isEmpty()){
                    int l = stack.peek();
                    if(l+1 <= k){
                        int current_Area = h * (r - l - 1);
                        area = Math.max(area , current_Area);
                    }
                }
                else{
                    int current_Area = h * r;
                    area = Math.max(area , current_Area);
                }
            }
        }

        return area;
    }
}
