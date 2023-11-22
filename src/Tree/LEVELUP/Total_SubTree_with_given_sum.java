package Tree.LEVELUP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
We are given a binary tree having N+1 nodes ,N edges and an integer X. The task is to find the count of the total
number of subtrees having total node’s data sum equal to a value X.

Note : Tree can be build using Level Order Traversal, using the iteration over the given string.
Tree is Complete Binary Tree.

Input Format
First line of input contains the number of test cases T.
For each T, First line is a single line of input in the form of string representing the tree.
Next line contains X(given sum).

Constraints
1 <= N <= 10^3
1 <= T <= 100
-10^3 <= Node Value <= 10^3

Output Format
Print the count the number of subtrees with given sum.

Sample Input
1
1 2 3
5
Sample Output
0
Explanation
None
*/
public class Total_SubTree_with_given_sum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String st = sc.nextLine();
            int target = sc.nextInt();
            BinaryTree tree = new BinaryTree(st);
            display(tree.root);
        }
    }

    static void display(Node root) {
        if (root == null) {
            return;
        }

        String ans = "";
        ans += root.data;

        if (root.left != null) {
            ans = root.left.data + " => " + ans;
        } else {
            ans = "END" + " => " + ans;
        }

        if (root.right != null) {
            ans = ans + " <= " + root.right.data;
        } else {
            ans = ans + " <= " + "END";
        }

        System.out.println(ans);
        display(root.left);
        display(root.right);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree(String input) {
        System.out.println(input);
        String[] arr = input.split(" ");
        System.out.println(Arrays.toString(arr));
        // createTree(arr);

    }

    private void createTree(String[] arr) {
        if (arr.length == 0) {
            return;
        }

        Node node = new Node(Integer.parseInt(arr[0]));
        this.root = node;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node curr = queue.remove();


            Node leftChild = new Node(Integer.parseInt(arr[i++]));
            curr.left = leftChild;
            queue.add(leftChild);

            if (i < arr.length) {
                Node rightChild = new Node(Integer.parseInt(arr[i++]));
                curr.right = rightChild;
                queue.add(rightChild);
            }
        }
    }
}