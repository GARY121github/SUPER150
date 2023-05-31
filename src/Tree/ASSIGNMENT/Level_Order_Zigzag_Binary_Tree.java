package Tree.ASSIGNMENT;

/*
Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on.
This means odd levels should get printed from left to right and even levels should be printed from right to left.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it
is NULL

Constraints
None

Output Format
Display the values in zigzag level order in which each value is separated by a space

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10 30 20 40 50 60 73
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Order_Zigzag_Binary_Tree {
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        List<List<Integer>> ans = zigzagLevelOrder(tree.root);

        for(List<Integer> i : ans){
            for (int j : i){
                System.out.print(j + " ");
            }
        }
        System.out.println();

    }

    static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int i = 0;
        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                }
                else{
                    if(i % 2 == 0){
                        ans.add(list);
                    }
                    else{
                        List<Integer> list2 = new ArrayList<>();
                        for(int j = list.size()-1 ; j>=0 ; j--){
                            list2.add(list.get(j));
                        }
                        ans.add(list2);
                    }
                    i++;
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

        if(i % 2 == 0){
            ans.add(list);
        }
        else{
            List<Integer> list2 = new ArrayList<>();
            for(int j = list.size()-1 ; j>=0 ; j--){
                list2.add(list.get(j));
            }
            ans.add(list2);
        }

        return ans;
    }
}
