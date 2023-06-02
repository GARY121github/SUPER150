package Tree.ASSIGNMENT;

/*
Given a Binary tree check if it is balanced i.e. depth of the left and right sub-trees of every node differ by 1 or less.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests
it is NULL

Constraints
1 <= No of nodes <= 10^5

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The tree looks like

             10
          /       \
       20           30
    /     \       /     \
   40      50    60      73
The given tree is clearly balanced as depths of the left and right sub-trees of every node differ by 1 or less.
*/

public class Is_Balanced_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        boolean ans = isBalanced(tree.root);
        System.out.println(ans);
    }

    static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }

        int left_sub_tree_height = height(root.left);
        int right_sub_tree_height = height(root.right);

        int balance_factor = Math.abs(left_sub_tree_height - right_sub_tree_height);
        if(balance_factor > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    static int height(Node root){
        if(root == null){
            return -1;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left , right) + 1;
    }
}
