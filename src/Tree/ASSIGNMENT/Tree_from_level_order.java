package Tree.ASSIGNMENT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tree_from_level_order {
    public Node root;
    static Scanner sc = new Scanner(System.in);
    public Tree_from_level_order(){
        tree();
    }

    private void tree() {
        Queue<Node> queue = new LinkedList<>();
        int n = sc.nextInt();
        if(n == -1){
            return;
        }

        Node node = new Node(n);
        this.root = node;
        queue.add(node);
        while (!queue.isEmpty()){

            Node current = queue.remove();

            int left = sc.nextInt();
            int right = sc.nextInt();

            if(left != -1){
                Node l = new Node(left);
                current.left = l;
                queue.add(l);
            }
            if(right != -1){
                Node r = new Node(right);
                current.right = r;
                queue.add(r);
            }
        }
    }
}
