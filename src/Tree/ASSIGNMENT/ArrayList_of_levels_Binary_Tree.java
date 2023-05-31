package Tree.ASSIGNMENT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a Binary tree, write code to create a separate array list for each level. You should return an arraylist of arraylist.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is
NULL

Constraints
None

Output Format
Display the resulting arraylist of arraylist according to given sample examples.

Sample Input
50 true 12 true 18 false false true 13 false false false
Sample Output
[[50], [12], [18, 13]]
*/
public class ArrayList_of_levels_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        List<List<Integer>> list = levelOrder(tree.root);
        System.out.println(list);
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
