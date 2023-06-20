package Tree.ASSIGNMENT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary tree and an integer sum,Print count of root-to-leaf paths that have path's sum equal to given integer sum.

Input Format
The first line contains level order traversal of the tree . In the level order traversal given, -1 represent a null child while
any other value represent a node of the tree.
Next line contains a single integer sum.

Constraints
1<=number of nodes in the tree <=10^5

Output Format
Print a single integer equal to number of root to leaf paths with given sum.

Sample Input
1 2 3 -1 -1 -1 -1
3
Sample Output
1
Explanation
There is only 1 root to leaf path with sum 3 (from 1 to 2).
*/
public class Root_to_Leaf_2 {
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
        int target = sc.nextInt();
        display(root);

        System.out.println(count(root , target , ""));
    }
    static int count(Node root , int target , String ans){
        if(root == null){
            return 0;
        }

        if(root.data == target){
            System.out.println(ans + root.data);
            return 1;
        }

        target -= root.data;
        int left = count(root.left , target , ans + root.data + "->");
        int right = count(root.right , target,  ans + root.data + "->");
        target += root.data;

        return left+right;
    }
    static void display(Node root){
        if(root == null){
            return;
        }

        String ans = "";
        ans += root.data;

        if(root.left != null){
            ans = root.left.data + " => " + ans;
        }
        else{
            ans = "END" + " => " + ans;
        }

        if(root.right != null){
            ans = ans + " <= " + root.right.data;
        }
        else{
            ans = ans + " <= " + "END";
        }

        System.out.println(ans);
        display(root.left);
        display(root.right);
    }

}
