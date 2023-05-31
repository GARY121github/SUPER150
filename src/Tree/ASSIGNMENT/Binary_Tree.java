package Tree.ASSIGNMENT;

import java.util.Scanner;

class Binary_Tree {
    static Scanner sc = new Scanner(System.in);
    public Node root;

    public Binary_Tree() {
        this.root = CreateBinaryTree();
    }

    private Node CreateBinaryTree() {
        int data = sc.nextInt();
        Node node = new Node(data);
        boolean has_left_child = sc.nextBoolean();
        if (has_left_child) {
            node.left = CreateBinaryTree();
        }

        boolean has_right_child = sc.nextBoolean();
        if (has_right_child) {
            node.right = CreateBinaryTree();
        }

        return node;
    }
}
