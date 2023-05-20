package Tree;

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

    public static void main(String[] args) {
        BinaryTree ob = new BinaryTree();
        ob.display();
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
