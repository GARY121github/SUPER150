package Tree;

public class Find_the_height_of_Binary_tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println(height(tree.root));
    }

    static int height(Node node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left , right) + 1;
    }
}
