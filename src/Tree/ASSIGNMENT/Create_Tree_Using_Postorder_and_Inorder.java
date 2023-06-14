package Tree.ASSIGNMENT;

import java.util.Scanner;
/*
Given postorder and inorder traversal of a tree. Create the original tree on given information.

Input Format
Enter the size of the postorder array N then add N more elements and store in the array, then enter the size of the inorder
array M and add M more elements and store in the array. here M and N are same.

Constraints
None

Output Format
Display the tree using the display function

Sample Input
3
1
3
2
3
1
2
3
Sample Output
1 => 2 <= 3
END => 1 <= END
END => 3 <= END
*/

public class Create_Tree_Using_Postorder_and_Inorder {
    public static void main(String[] args) {
        Main m = new Main();
        int[] post = Main.takeInput();
        int[] in = Main.takeInput();
        Main.BinaryTree bt = m.new BinaryTree(post, in);
        bt.display();
    }
}
class Main {

    static Scanner scn = new Scanner(System.in);



    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
            return createTree(in , ilo , ihi , post , plo , phi);
        }
        private Node createTree(int[] arr , int s1 , int e1 , int[] brr , int s2 , int e2){
            if(s1 > e1 || s2 > e2){
                return null;
            }
            System.out.println(e2);
            Node node = new Node();
            node.data = brr[e2];
            int index = Index(arr , s1 , e1 , brr[e2]);
            int child = e1 - index;
            node.left = createTree(arr , s1 , index - 1 , brr , s2 , e2 - child - 1);
            node.right = createTree(arr , index + 1 , e1 , brr , e2 - child , e2-1);
            return node;

        }

        private int Index(int[] arr , int s , int e , int target){
            while(s <= e){
                if(arr[s] == target){
                    return s;
                }
                s++;
            }
            return -1;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}

