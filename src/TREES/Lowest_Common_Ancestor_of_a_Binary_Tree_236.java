package TREES;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }

            if(root.val == p.val || root.val == q.val){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left , p , q);
            TreeNode right = lowestCommonAncestor(root.right , p , q);

            if(left != null && right != null){
                return root;
            }

            // if(left == null && right == null){
            //     return null;
            // }

            // if(left != null){
            //     return left;
            // }

            // if(right != null){
            //     return right;
            // }

            if(left == null){
                return right;
            }
            else{
                return left;
            }
        }
    }
}