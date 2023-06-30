package Tree.ASSIGNMENT;

import java.util.Scanner;

/**

 Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.

 Input Format
 Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it
 is NULL next two line contains 2 element of BT

 Constraints
 None

 Output Format
 Display the LCA value.

 Sample Input
 10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
 50
 60
 Sample Output
 10

 **/
public class Lowest_Common_Ancestor_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        System.out.println(LCA(tree.root , p1 , p2).data);
    }

    private static Node LCA(Node root , int p1 , int p2){
        if(root == null){
            return null;
        }

        if (root.data == p1 || root.data == p2){
            return root;
        }
        Node left = LCA(root.left , p1 , p2);
        Node right = LCA(root.right , p1 , p2);

        if(left != null && right != null){
            return root;
        }
        else if(left == null){
            return right;
        }
        else{
            return left;
        }
    }
}
