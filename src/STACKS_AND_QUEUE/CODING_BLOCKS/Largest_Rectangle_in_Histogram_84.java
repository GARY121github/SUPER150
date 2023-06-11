package STACKS_AND_QUEUE.CODING_BLOCKS;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
    }

    static int histogram(int[] heights){
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < heights.length ; i++){

//            WHEN WE FIND THE RIGHT MINIMUM OF THE PARTICULAR ELEMENT CALC. THE AREA
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
//                RIGHT MINIMUM
                int right = i;
                int height = heights[stack.pop()];

                if(!stack.isEmpty()){
                    int left = stack.peek();

                    int current_Area = height * (right - left - 1);
                    area = Math.max(current_Area , area);
                }
                else{
                    int current_Area = height * right;
                    area = Math.max(current_Area , area);
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int right = heights.length;
            int height = heights[stack.pop()];

            if(!stack.isEmpty()){
                int left = stack.peek();

                int current_Area = height * (right - left - 1);
                area = Math.max(current_Area , area);
            }
            else{
                int current_Area = height * right;
                area = Math.max(current_Area , area);
            }
        }

        return area;
    }
}
