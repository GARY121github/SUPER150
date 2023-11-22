package Tree.ASSIGNMENT;

/*
Given a binary tree, print its nodes level by level in reverse order, i.e., print all nodes present at the last level first,
followed by nodes of the second last level and so on. Print nodes at any level from left to right.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests
it is NULL

Constraints
The number of nodes in the tree is in the range [1, 1000]
0 <= root->data <= 1000

Output Format
Reverse level order print of the node values.

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
40 50 60 73 20 30 10
Explanation
Last level should be printed first, then second last , then third last and so on.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_Level_Order_Traversal {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        List<List<Integer>> list = reverseLevelOrder(tree.root);
        for(List<Integer> i : list){
            for (int j : i){
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }
    static List<List<Integer>> reverseLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                }
                else{
                    ans.add(0 ,list);
                    list = new ArrayList<>();
                    queue.add(null);
                    continue;
                }
            }

            list.add(current.data);
            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }

        ans.add(0 ,list);
        return ans;
    }
}
