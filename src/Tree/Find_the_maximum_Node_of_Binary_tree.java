package Tree;

public class Find_the_maximum_Node_of_Binary_tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println(findMax(tree.root));
    }

    static int findMax(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int left = findMax(node.left);
        int right = findMax(node.right);

        return Math.max(node.data , Math.max(left , right));
    }
}
