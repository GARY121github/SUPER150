package Tree;


public class Binary_Search_Tree {

    public Node root;

    public Binary_Search_Tree(int[] preOrderArray){
        this.root = createBST(preOrderArray , 0 , preOrderArray.length-1);

    }

    private Node createBST(int[] arr , int s , int e) {
        if(s > e){
            return null;
        }

        int mid = (s+e) / 2;
        Node node = new Node(arr[mid]);

        node.left = createBST(arr , s , mid-1);
        node.right = createBST(arr, mid+1 , e);

        return node;
    }
    static void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ") ;
        inOrder(node.right);
    }


    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5};
        Binary_Search_Tree BST = new Binary_Search_Tree(arr);
        inOrder(BST.root);
    }
}
