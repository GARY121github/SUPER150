package Recursion;
/*

Take an input N, a number. Take N more inputs and store that in an array. Take an input target, a number
a. Write a recursive function which prints subsets of the array which sum to target.
b. Write a recursive function which counts the number of subsets of the array which sum to target.
Print the value returned.
Input Format
Take an input N, a number. Take N more inputs and store that in an array. Take an input target, a number
Constraints
None
Output Format
Display the number of subsets and print the subsets in a space separated manner.
Sample Input
3
1
2
3
3
Sample Output
1 2  3
2
Explanation
Add 2 spaces between 2 subset solutions
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Subsets_78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        subSequenceSum(list, arr, li, k, 0);
        print(list);

    }

    static void print(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> li : list) {
            for (int i : li) {
                System.out.print(i + " ");
            }
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(list.size());
    }

    public static void subSequenceSum(
            ArrayList<ArrayList<Integer>> ans,
            int a[], ArrayList<Integer> temp,
            int k, int start) {
        // Here we have used ArrayList
        // of ArrayList in Java for
        // implementation of Jagged Array

        // if k < 0 then the sum of
        // the current subsequence
        // in temp is greater than K
        if (start > a.length || k < 0)
            return;

        // if(k==0) means that the sum
        // of this subsequence
        // is equal to K
        if (k == 0) {
            ans.add(
                    new ArrayList<Integer>(temp)
            );
            return;
        } else {
            for (int i = start;
                 i < a.length; i++) {
                // Adding a new
                // element into temp
                temp.add(a[i]);

                // After selecting an
                // element from the
                // array we subtract K
                // by that value
                subSequenceSum(ans, a,
                        temp, k - a[i], i + 1);

                // Remove the lastly
                // added element
                temp.remove(temp.size() - 1);
            }
        }
    }
}
