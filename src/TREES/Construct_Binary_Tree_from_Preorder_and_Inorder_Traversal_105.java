package TREES;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length-1);
    }
    private TreeNode createTree(int[] preOrder , int sp , int ep , int[] inOrder , int si , int ei){

        if(sp > ep || si > ei){
            return null;
        }


        TreeNode root = new TreeNode(preOrder[sp]);
        int index = index(inOrder , si , ei , preOrder[sp]);
        int left_children = index - si;
        // int right_children = ei - index;
        root.left = createTree(preOrder , sp+1 , sp + left_children, inOrder , si , index - 1);
        root.right = createTree(preOrder , sp + left_children + 1 , ep , inOrder , index + 1 , ei);

        return root;

    }

    private int index(int[] arr , int s , int e , int target){
        while(s <= e){

            if(arr[s] == target){
                return s;
            }

            s++;
        }

        return -1;
    }
}
