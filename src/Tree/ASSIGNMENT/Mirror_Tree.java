package Tree.ASSIGNMENT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 Given a binary tree , Check if its mirror image is equal to the tree itself.

 Input Format
 The first line of the input contains level order traversal of the tree as space separated integers . In the level order traversal ,
 -1 represent a null child while any other value represent a node of the tree.

 Constraints
 1<=number of nodes in the tree <=10^5

 Output Format
 Print "YES" without quotes if the mirror image of the tree is equal to the tree itself , else print "NO" without quotes.

 Sample Input
 1 2 2 -1 -1 -1 -1
 Sample Output
 YES
 Explanation
 The mirror image of given tree is equal to the tree itself.
 **/
public class Mirror_Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    static Node root = null;
    static Scanner sc = new Scanner(System.in);
    static void construct_tree(){
        int n = sc.nextInt();
        if(n == -1){
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        Node node = new Node(n);
        root = node;
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
    }

    public static void main(String[] args) {
        construct_tree();
        boolean isMirror = isMirror(root , root);
        if(isMirror){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    static boolean isMirror(Node tree1 , Node tree2){
        if(tree1 == null && tree2 == null){
            return true;
        }

        if(tree1 == null || tree2 == null){
            return false;
        }

        if(tree1.data != tree2.data){
            return false;
        }

        boolean left = isMirror(tree1.left , tree2.right);
        boolean right = isMirror(tree1.right , tree2.left);

        return left && right;
    }

}
