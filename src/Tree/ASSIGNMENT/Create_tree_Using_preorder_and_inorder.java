package Tree.ASSIGNMENT;

/*
Given preorder and inorder create the tree

Input Format
Enter the size of the preorder array N then add N more elements and store in the array denoting the preorder traversal of the tree.
Then enter the size of the inorder array M and add M more elements and store the inorder traversal of the array.

Constraints
1 <= N, M <= 10^4

Output Format
Display the tree using a modified preorder function. For each node , first print its left child's data , then the data of the root
itself , then the data of its right child. Do this for each node in a new line in preorder manner. If one of the children does not
exist print END in its place. Refer to the sample testcase.

Sample Input
3
1 2 3
3
3 2 1
Sample Output
2 => 1 <= END
3 => 2 <= END
END => 3 <= END
Explanation
The above tree looks like
         1
       /
     2
   /
 3
*/

import java.util.Scanner;

public class Create_tree_Using_preorder_and_inorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preOrder = new int[n];
        for(int i = 0 ; i < n ; i++){
            preOrder[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] inOrder = new int[m];
        for(int i = 0 ; i < m ; i++){
            inOrder[i] = sc.nextInt();
        }

        Node root = createTree(preOrder , 0 , n-1 , inOrder , 0 , m-1);
        display(root);
    }

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
    private static void display(Node root){
        if(root == null){
            return;
        }

        String ans = " => " + root.data + " <= ";

        if(root.left != null){
            ans = root.left.data + ans;
        }
        else {
            ans = "END" + ans;
        }

        if(root.right != null){
            ans = ans + root.right.data;
        }
        else {
            ans = ans + "END";
        }

        System.out.println(ans);
        display(root.left);
        display(root.right);

    }
}
