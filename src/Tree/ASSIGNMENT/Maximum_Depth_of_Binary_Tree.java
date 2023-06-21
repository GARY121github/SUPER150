package Tree.ASSIGNMENT;
/**
 Given a binary tree, find the maximum depth of the tree.

 Input Format
 Enter the value of the node then the Boolean choice i.e whether the node has a left child , then enter the left child's data .
 The input acts in a recursive manner i.e when the left child's children are made only then we move onto the parent's right child

 Constraints
 None

 Output Format
 Print the depth of the binary tree.

 Sample Input
 10 true 20 true 73 false false true 50 false false true 30 true 60 false false true 73 false false
 Sample Output
 3
 Explanation
 Calculate the maximum height of the tree.


 **/
public class Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        System.out.println(maxHeight(tree.root));
    }

    static int maxHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        return Math.max(left , right) + 1;
    }
}
