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
        System.out.println(isSI(root1.root , root2.root));
    }

    static boolean isSI(Node node1, Node node2)
    {
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }

        int left1 = 0;
        Node temp = node1;
        while(temp != null){
            left1++;
            temp = temp.left;
        }

        int left2 = 0;
        temp = node2;
        while(temp != null){
            left2++;
            temp = temp.left;
        }

        if(left1 != left2){
            return false;
        }

        temp = node1;
        int right1 = 0;
        while(temp!=null){
            right1++;
            temp =temp.right;
        }
        temp = node2;
        int right2 = 0;
        while(temp!=null){
            right2++;
            temp =temp.right;
        }
        if(right1 != right2){
            return false;
        }
        boolean left = isSI(node1.left , node2.left);
        boolean right = isSI(node1.right , node2.right);
        return left && right;
    }
}

