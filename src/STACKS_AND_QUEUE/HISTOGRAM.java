package STACKS_AND_QUEUE;

import java.util.Stack;

public class HISTOGRAM {
    public static void main(String[] args) {
        int N = 8;
        int arr[] = {7, 2 ,8 ,9 ,1 ,3 ,6 ,5};
    }
    public static long getMaxArea(long[] arr, long n)
    {
        long area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){

//            IF THE CURRENT VALUE IS SMALLER THAN THE PEAK OF THE STACK THAN WE HAVE FOUND THE RIGHT MIN.

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                long right_min = i;
                long height = arr[stack.pop()];
                if(!stack.isEmpty()){
                    long left_min = stack.peek();
                    long current_Area = (right_min - left_min - 1) * height;
                    area = Math.max(current_Area , area);
                }else{
                    long current_Area = right_min * height;
                    area = Math.max(current_Area , area);
                }
            }

            stack.push(i);
        }

        long right_min = arr.length;
        while (!stack.isEmpty()){
            long height = arr[stack.pop()];
            if(!stack.isEmpty()){
                long left_min = stack.peek();
                long current_Area = (right_min - left_min - 1) * height;
                area = Math.max(current_Area , area);
            }else{
                long current_Area = right_min * height;
                area = Math.max(current_Area , area);
            }
        }

        return area;
    }
}
