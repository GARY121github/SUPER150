package Tree.ASSIGNMENT;

/*
Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

Input Format
First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists
and false suggests it is NULL. Second line contains the number k.

Constraints
None

Output Format
Display the root to leaf path whose sum is equal to k.

Sample Input
10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
60
Sample Output
10 20 30
Explanation
The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.
*/

import Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Root_to_Leaf_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        rootToLeaf(tree.root , target);
        for(String i : list){
            System.out.println(i);
        }
    }
    static List<String> list = new ArrayList<>();
    static void rootToLeaf(Node root , int target){
        if(root == null){
            return;
        }

        targetSum(root , "" , target);
    }
    static void targetSum(Node root , String ans , int target){
        if(root == null){
            return;
        }

        if(target - root.data == 0){
            ans += root.data + " ";
            list.add(ans);
        }

        targetSum(root.left , ans + root.data + " " , target - root.data);
        targetSum(root.right , ans + root.data + " " , target - root.data);
    }

}
