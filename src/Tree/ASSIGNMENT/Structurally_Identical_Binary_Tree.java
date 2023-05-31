package Tree.ASSIGNMENT;

/*
Given two trees check if they are structurally identically. Structurally identical trees are trees that have same structured.
They may or may not have the same data though.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it
is NULL

Constraints
1 <= N <= 10^4

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The given two trees have the exact same structure and hence we print true.

*/



import java.util.Scanner;

public class Structurally_Identical_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree root1 = new Binary_Tree();
        Binary_Tree root2 = new Binary_Tree();
        System.out.println(isIdentical(root1.root , root2.root));

    }

    static boolean isIdentical(Node root1 , Node root2){
        if(root1 == null && root2 == null){
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }

        boolean left = isIdentical(root1.left , root2.left);
        boolean right = isIdentical(root1.right , root2.right);

        return left && right;
    }
}

