package Tree.ASSIGNMENT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 Given a binary tree, determine whether it is a BST.

 Input Format
 Level order traversals given where -1 means child is NULL

 Constraints
 -10^5<=nodes.data<=10^5

 Output Format
 true or false

 Sample Input
 20 10 30 -1 -1 5 40 -1 -1 -1 -1
 Sample Output
 false
 Explanation
 In the tree above, lefeach node meets the condition that the node contains a value larger than its t child and smaller than its right
 child hold, and yet it’s not a BST: the value 5 is on the right subtree of the node containing 20, a violation of the BST property.
 **/
public class Determine_whether_a_given_binary_tree_is_a_BST_or_not {
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
                Node ob = new Node(right);
                current.right = ob;
                queue.add(ob);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = createTree();
        System.out.println(isBST(root).isBST);
    }

    static class Pair{
        boolean isBST = true;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
    }

    static Pair isBST(Node root){
        if(root == null){
            return new Pair();
        }

        Pair left = isBST(root.left);
        Pair right = isBST(root.right);

        Pair self = new Pair();

        if(left.isBST && right.isBST && left.max < root.data && right.min > root.data){
            self.min = Math.min(left.min , root.data);
            self.max = Math.max(right.max , root.data);
            return self;
        }

        self.isBST = false;
        return self;
    }
}
