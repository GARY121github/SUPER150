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
        for (int i = 0 ; i < m ; i++){
            inOrder[i] = sc.nextInt();
        }
        Node root = createTree(preOrder , 0 , preOrder.length-1 , inOrder , 0 , inOrder.length-1);
        display(root);
    }

    private static Node createTree(int[] arr1 , int s1 , int e1 , int[] arr2 , int s2 , int e2){
        if(s1 > e1 || s2 > e2){
            return null;
        }
        int data = arr1[s1];
        Node node = new Node(data);
        int i = index(arr2 , s2 , e2 , data);
        int childs = i - s2;
        node.left = createTree(arr1 , s1+1 , s1 + childs , arr2 , s2 , i-1);
        node.right = createTree(arr1 , s1 + childs + 1 , e1 , arr2 , i+1 , e2);
        return node;
    }
    private static int index(int[] arr , int s , int e , int target){
        for(int i = s ; i <= e ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    static void display(Node node){
        if(node == null){
            return;
        }

        String ans = "";
        ans = ans + node.data;
        if(node.left != null){
            ans = node.left.data + " <= " + ans;
        }
        else{
            ans = "END" + " <= " + ans;
        }

        if(node.right != null){
            ans = ans + " => " + node.right.data;
        }
        else {
            ans = ans + " => " + "END";
        }

        System.out.println(ans);
        display(node.left);
        display(node.right);
    }

}
