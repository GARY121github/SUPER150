package TREES;

public class Path_Sum_III_437 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public int pathSum(TreeNode root, int target) {
            if(root == null){
                return 0;
            }


            int current = hasPath(root , target);

            int left = pathSum(root.left , target);
            int right = pathSum(root.right , target);


            return left + right + current;
        }

        private int hasPath(TreeNode root , long target){
            if(root == null){
                return 0;
            }

            int current = 0;
            if(root.val == target){
                current += 1;
            }

            int left = hasPath(root.left , target - root.val);
            int right = hasPath(root.right , target - root.val);

            return current + left + right;
        }
    }
    public static void main(String[] args) {

    }
}
