package TREES;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_USING_LEVEL_ORDER {
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    Node root = null;
    public BST_USING_LEVEL_ORDER(){
        this.root = createBST();
    }

    private Node createBST() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextByte();
        if(r == -1){
            return null;
        }

        Node root = new Node(r);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.remove();

            int lc = sc.nextInt();
            int rc = sc.nextInt();

            if(lc != -1){
                Node ob = new Node(lc);
                current.left = ob;
                queue.add(ob);
            }
            if(rc != -1){
                Node ob = new Node(rc);
                current.right = ob;
                queue.add(ob);
            }
        }

        return root;
    }

    static void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ") ;
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BST_USING_LEVEL_ORDER tree = new BST_USING_LEVEL_ORDER();
        inOrder(tree.root);

//        input -> 10 6 13 5 7 12 14 -1 -1 -1 -1 -1 -1 -1 -1
    }
}
