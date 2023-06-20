package Tree.ASSIGNMENT;

import java.util.Scanner;

/*
Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. Include the current node's data also.

Input Format
The first line contains a number n showing the length of the inorder array of BST. The next line contains n integers denoting the elements of the array.

Constraints
2 ≤ N ≤ 10^3

Output Format
Print the preorder traversal of the new tree.

Sample Input
7
20
30
40
50
60
70
80
Sample Output
260 330 350 300 150 210 80
Explanation
The original tree looks like

            50
        /        \
      30          70
    /    \       /   \
  20    40      60    80
We are supposed to replace the elements by the sum of elements larger than it.
80 being the largest element remains unaffected .
70 being the second largest element gets updated to 150 (70+80)
60 becomes 210 (60 + 70 + 80)
50 becomes 260 (50 + 60 + 70 + 80)
40 becomes 300 (40 + 50 + 60 + 70 + 80)
30 becomes 330 (30 + 40 + 50 + 60 + 70 + 80)
20 becomes 350 (20 + 30 + 40 + 50 + 60 + 70 + 80)

The new tree looks like

           260
        /        \
     330         150
    /    \       /   \
  350    300   210    80
The Pre-Order traversal (Root->Left->Right) looks like :
260 330 350 300 150 210 80.
*/
public class Replace_with_Sum_of_greater_nodes {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    static Node createTree(int[] arr , int s , int e){
        if(s > e){
            return null;
        }

        int mid = (s+e) / 2;
        Node root = new Node(arr[mid]);

        root.left = createTree(arr , s , mid-1);
        root.right = createTree(arr , mid+1 , e);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        Node root = createTree(arr , 0 , arr.length-1);
        totalSum(root);
        replace(root);
        preOrderDisplay(root);
        System.out.println();
    }

    static int sum = 0;

    static void totalSum(Node root){
        if(root == null){
            return;
        }

        sum += root.data;

        totalSum(root.left);
        totalSum(root.right);
    }
    static void replace(Node root){
        if (root == null){
            return;
        }

        replace(root.left);
        int temp = root.data;
        root.data = sum;
        sum -= temp;
        replace(root.right);
    }

    static void preOrderDisplay(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderDisplay(root.left);
        preOrderDisplay(root.right);
    }
}