package Tree.ASSIGNMENT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 Given a binary tree, find the maximum path sum in it.
 The path is defined as a sequence of nodes that follows parent-child connection.Path may start from any node and end at any node.

 Input Format
 The first line of input contains level order traversal of the tree.In the input , a -1 value represent a null child while any other
 value represent a node in the tree.

 Constraints
 1<=number of nodes in the tree <=10^5

 Output Format
 Print a single integer equal to maximum path sum in the given tree.

 Sample Input
 1 4 6 -1 -1 -1 -1
 Sample Output
 11
 Explanation
 The path with maximum sum is from the root's left child(4) to root's right child(6) with sum as 11(4+1+6)
 **/
public class Binary_Tree_Maximum_Path_Sum {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    static Node createTree(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == -1){
            return null;
        }

        Node root = new Node(n);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.remove();
            int left = sc.nextInt();
            int right = sc.nextInt();

            if(left != -1){
                Node ob = new Node(left);
                current.left = ob;
                queue.add(ob);
            }
            if(right != -1){

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = createTree();
    }


}
