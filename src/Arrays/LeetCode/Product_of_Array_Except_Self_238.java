package Arrays.LeetCode;
/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.)
*/


import java.util.Scanner;
public class Product_of_Array_Except_Self_238 {
    public static void main(String[] args) {


    }

    public int[] productExceptSelf(int[] nums) {

//         int[] left_product = new int[nums.length];
//         left_product[0] = 1;
//         int[] right_product = new int[nums.length];
//         right_product[nums.length - 1] = 1;

//         for(int i = 1 ; i < nums.length ; i++){
//             left_product[i] = left_product[i-1] * nums[i-1];
//         }

//         for(int i = nums.length - 2 ; i>=0 ; i--){
//             right_product[i] = right_product[i+1] * nums[i+1];
//         }

//         for(int i = 0 ; i < nums.length ; i++){
//             nums[i] = left_product[i] * right_product[i];
//         }
//         return nums;



        int mul=1;
        int[] answer = new int[nums.length];

        //Left array
        for(int i=0;i<nums.length;i++) {
            answer[i] = mul;
            mul*=nums[i];
        }

        //Right array
        mul=1;
        for(int i=nums.length-1;i>=0;i--) {
            answer[i] = answer[i]*mul;
            mul*=nums[i];
        }

        return answer;

    }
}
