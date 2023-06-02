package Tree.ASSIGNMENT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree. Print the level order traversal, make sure each level start at a new line.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests
it is NULL

Constraints
None

Output Format
Print the level order in which the different levels are in different lines, all the values should be in a space separated manner

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10
20 30
40 50 60 73
*/
public class Level_Order_New_Line_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        List<List<Integer>> ans = levelOrder(tree.root);
        for(List<Integer> i : ans){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
    static List<List<Integer>> levelOrder(Node root) {
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
                    ans.add(list);
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

        ans.add(list);
        return ans;
    }

}
