package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    public Node root = null;
    public BinaryTree(){
        this.root = createBinaryTree();
    }

    static Scanner sc = new Scanner(System.in);
    private Node createBinaryTree() {
        int data = sc.nextInt();
        Node node = new Node(data);

        boolean hasLeftChild = sc.nextBoolean();
        if(hasLeftChild){
            node.left = createBinaryTree();
        }

        boolean hasRightChild = sc.nextBoolean();
        if(hasRightChild){
            node.right = createBinaryTree();
        }

        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node){
        if(node == null){
            return;
        }

        String ans = "";
        ans = ans + node.data;
        if(node.left != null){
            ans = node.left.data + " <-- " + ans;
        }
        else{
            ans = "NULL" + " <-- " + ans;
        }

        if(node.right != null){
            ans = ans + " --> " + node.right.data;
        }
        else {
            ans = ans + " --> " + "NULL";
        }

        System.out.println(ans);
        display(node.left);
        display(node.right);
    }

//    TRAVERSALS

//    PRE-ORDER => ROOT -> LEFT -> RIGHT
    public void PreOrder(){
        PreOrder(this.root);
        System.out.println();
    }

    private void PreOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

//    IN-ORDER => LEFT -> ROOT -> RIGHT
    public void InOrder(){
        InOrder(this.root);
        System.out.println();
    }

    private void InOrder(Node node){
        if(node == null){
            return;
        }
        InOrder(node.left);
        System.out.print(node.data + " ");
        InOrder(node.right);
    }

//    POST-ORDER => LEFT -> RIGHT -> ROOT
    public void PostOrder(){
        PostOrder(this.root);
        System.out.println();
    }

    public void PostOrder(Node node){
        if(node == null){
            return;
        }

        PostOrder(node.left);
        PostOrder(node.right);

        System.out.print(node.data + " ");
    }

    public void LevelOrder(){
        LevelOrder(this.root);
    }

    public void LevelOrder(Node node){

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node curr = queue.remove();

            System.out.println(curr.data + " ");

            if(curr.left != null){
                queue.add(curr.left);
            }

            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree ob = new BinaryTree();
        ob.display();
//        ob.PreOrder();
//        ob.InOrder();
//        ob.PostOrder();
        ob.LevelOrder();

//  10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
        }

}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
