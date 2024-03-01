package TREES;

public class Binary_Search_Tree {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    Node root;

    public Binary_Search_Tree(int[] arr){
        this.root = createBST(arr , 0 , arr.length-1);
    }

    private Node createBST(int[] arr , int s , int e){
        if(s > e){
            return null;
        }

        int mid = (s + e) / 2;

        Node node = new Node(arr[mid]);

        node.left = createBST(arr , s , mid-1);
        node.right = createBST(arr , mid+1 , e);

        return node;
    }
}
