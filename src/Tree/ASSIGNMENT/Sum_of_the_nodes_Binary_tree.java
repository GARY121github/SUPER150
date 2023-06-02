package Tree.ASSIGNMENT;

/*
Given a binary tree find sum of all the nodes.

Input Format
Enter the value of the node then the Boolean choice i.e whether the node has a left child , then enter the left child's data .
The input acts in a recursive manner i.e when the left child's children are made only then we move onto the parent's right child

Constraints
None

Output Format
Display the sum of all the nodes

Sample Input
50 true 25 true 12 false false false true 75 true 62 false false false
Sample Output
224
Explanation
If we enter the following values

50 true 25 true 12 false false false true 75 true 62 false false false

the tree would look like :

25 => 50 <= 75

12 => 25 <= END

END => 12 <= END

62 => 75 <= END

END => 62 <= END
*/

public class Sum_of_the_nodes_Binary_tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        System.out.println(sum_of_nodes(tree.root));
    }

    static int sum_of_nodes(Node root){
        if(root == null){
            return 0;
        }

        return root.data + sum_of_nodes(root.left) + sum_of_nodes(root.right);
    }
}
