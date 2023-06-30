package Tree.ASSIGNMENT;

import java.util.*;

/*
Given a Binary tree, print the bottom-up level order traversal of its nodes, i.e. from left to right, each level from leaf to root.

Input Format
The only line of input contains N space-separated values, i.e. integers or N denoting a null node in their level-order traversal.

Constraints
|node.Value| ≤ 10^5

Output Format
Print each level on a new line, where the values of each node in the level are separated by a space.

Sample Input
3 9 2 N N 5 7
Sample Output
5 7
9 2
3
Explanation
    3
  /   \
 9      2
       /  \
      5     7
The levels in bottom-up would be, {5, 7}, {9, 2}, {3}.
*/
public class Bottom_Up_Level_Order {
    static class Node{
        String data;
        Node left;
        Node right;
        public Node(String data){
            this.data = data;
        }
    }

    private static Node createTree(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        if(arr[0].equals("N")){
            return null;
        }
//        System.out.println(Arrays.toString(arr));

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1 ; i < arr.length ; i+=2){
            String left = arr[i];
            String right = arr[i+1];

            Node current = queue.remove();
            if(!left.equals("N")){
                Node ob = new Node(left);
                current.left = ob;
                queue.add(ob);
            }

            if(!right.equals("N")){
                Node ob = new Node(right);
                current.right = ob;
                queue.add(ob);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node tree = createTree();
        List<List<Node>> ans = bottomUp(tree);
        for (List<Node> list : ans){
            for (Node i : list){
                System.out.print(i.data + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Node>> bottomUp(Node root){

        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> ans = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            Node current = queue.remove();

            if(current == null){
                if(queue.isEmpty()){
                    break;
                }
                else{
                    ans.add(0 , list);
                    list = new ArrayList<>();
                    queue.add(null);
                    continue;
                }
            }

            list.add(current);

            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }

        ans.add(0 , list);

        return ans;
    }

}
