package Tree.ASSIGNMENT;

/*
For each node in a binary search tree, create a new duplicate node, and insert the duplicate as the left child of the original node.

Input Format
Enter the number of nodes N and add N more numbers to the BST

Constraints
None

Output Format
Display the tree

Sample Input
3
2
1
3
Sample Output
2 => 2 <= 3
1 => 2 <= END
1 => 1 <= END
END => 1 <= END
3 => 3 <=END
END => 3 <=END
*/

import java.util.Scanner;

public class Add_duplicate_BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Node root = null;
        for(int i = 0 ; i < arr.length ; i++){
            root = createDuplicateBST(root , arr[i]);
        }
        display(root);
    }
    private static Node createDuplicateBST(Node root , int data){
        if(root == null){
            Node node = new Node(data);
            Node duplicate = new Node(data);
            node.left = duplicate;
            return node;
        }

        if(root.data > data){
            root.left = createDuplicateBST(root.left , data);
        }
        else {
            root.right = createDuplicateBST(root.right , data);
        }

        return root;
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
