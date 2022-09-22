package Arrays.LeetCode;

/*
189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

public class Rotate_Array_189 {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
//         while(k-- > 0){
//             int t = nums[nums.length - 1];

//             for(int i = nums.length-1 ; i > 0 ; i--)
//                 nums[i] = nums[i-1];

//             nums[0] = t;
//         }
        reverse(nums , 0 , nums.length - 1);
        k = k % nums.length;

        // System.out.println(Arrays.toString(nums));
        reverse(nums , 0 , k-1);
        // System.out.println(Arrays.toString(nums));
        reverse(nums , k, nums.length - 1);
        // System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] arr , int s ,int e){
        while(s <= e){
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;

            s++;
            e--;
        }
    }

}
