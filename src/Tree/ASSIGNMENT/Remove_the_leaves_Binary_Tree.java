package Tree.ASSIGNMENT;

/*
Given a binary tree, remove all the leaves from the tree

Input Format
Enter the value of the nodes of the tree

Constraints
None

Output Format
Display the tree in which all the leaves have been removed in pre-order traversal in the following format :
Left->data => Root->data <= Right->Data
Output END if left or right node is NULL

Sample Input
50 true 12 true 18 false false false false
Sample Output
12 => 50 <= END
END => 12 <= END
*/
public class Remove_the_leaves_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        tree.root = removeLeafNode(tree.root);
        display(tree.root);
    }

    static Node removeLeafNode(Node root){
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return null;
        }

        root.left = removeLeafNode(root.left);
        root.right = removeLeafNode(root.right);

        return root;
    }

    static void display(Node root){
        if(root == null){
            return;
        }

        String ans = "";
        ans += root.data;

        if(root.left != null){
            ans = root.left.data + " => " + ans;
        }
        else{
            ans = "END" + " => " + ans;
        }

        if(root.right != null){
            ans = ans + " <= " + root.right.data;
        }
        else{
            ans = ans + " <= " + "END";
        }

        System.out.println(ans);
        display(root.left);
        display(root.right);
    }
}
