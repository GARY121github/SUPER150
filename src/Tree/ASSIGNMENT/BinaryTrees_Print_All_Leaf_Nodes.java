package Tree.ASSIGNMENT;

/*
Given a Binary Tree Print all the leaf nodes.

Input Format
Level order input of the binary tree

Constraints
Total no of nodes <1000

Output Format
All leaf nodes from left to right in single line

Sample Input
1
2 3
4 5
6 7
-1 -1
-1 -1
-1 -1
-1 -1
Sample Output
4 5 6 7
*/
public class BinaryTrees_Print_All_Leaf_Nodes {

    public static void main(String[] args) {
        Tree_from_level_order tree = new Tree_from_level_order();
        printLeaf(tree.root);
    }
    static void printLeaf(Node root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            System.out.print(root.data + " ");
            return;
        }

        printLeaf(root.left);
        printLeaf(root.right);
    }
}
