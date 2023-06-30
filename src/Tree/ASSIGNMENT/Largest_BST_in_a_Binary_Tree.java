package Tree.ASSIGNMENT;

import java.util.Scanner;

/*
Given a Binary Tree, write a program that returns the size of the largest subtree which is also a Binary Search Tree (BST)

Input Format
The first line of input will contain an integer n. The next line will contain n integers denoting the preorder traversal of the
BT. The next line will contain n more integers denoting the inorder traversal of the BT.

Constraints
2 ≤ N ≤ 10^3

Output Format
A single integer denoting the size ( no of nodes in tree ) of largest BST in the given tree.

Sample Input
4
60 65 50 70
50 65 60 70
Sample Output
2
Explanation
The tree looks like

             60
          /      \
       65           70
     /
   50
The largest BST subtree is

       65
     /
   50
which has the size 2 i.e. it has 2 nodes in it.
*/
public class Largest_BST_in_a_Binary_Tree {
    private static Node createTree(int[] preOrder , int sp , int ep , int[] inOrder , int si , int ei){
        if(sp > ep || si > ei){
            return null;
        }

        Node root = new Node(preOrder[sp]);
        int index = index(inOrder , si , ei , preOrder[sp]);
        int diff = index - si;
        root.left = createTree(preOrder , sp+1 , sp + diff , inOrder , si , index-1);
        root.right = createTree(preOrder , sp + diff + 1, ep , inOrder , index+1 , ei);

        return root;
    }

    private static int index(int[] arr , int s , int e , int target){
        while (s <= e){
            if(arr[s] == target){
                return s;
            }

            s++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preOrder = new int[n];
        for(int i = 0 ; i < n ; i++){
            preOrder[i] = sc.nextInt();
        }
        int[] inOrder = new int[n];
        for (int i = 0 ; i < n ; i++){
            inOrder[i] = sc.nextInt();
        }

        Node root = createTree(preOrder , 0 , n-1 , inOrder , 0 , n-1);
        isBST(root);
        System.out.println(max);

    }

    static int max = 0;
    static class Pair{
        boolean isBST = true;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int node = 0;
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
            self.node = left.node + right.node + 1;
            max = Math.max(self.node, max);
            return self;
        }

        self.isBST = false;
        return self;
    }


}
