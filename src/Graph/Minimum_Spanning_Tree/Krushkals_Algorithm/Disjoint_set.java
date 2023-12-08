package Graph.Minimum_Spanning_Tree.Krushkals_Algorithm;

import java.util.HashMap;

public class Disjoint_set {

    private class Node {
        int rank;
        Node parent;
        int data;

        public Node(int rank, int data) {
            this.rank = rank;
            this.data = data;
        }
    }

    private HashMap<Integer, Node> disjoint_set = new HashMap<>();

    public void createSet(int v) {
        Node set = new Node(0, v);

//        INITIALLY EVERY SET WILL BE ITS PARENT
        set.parent = set;
        disjoint_set.put(v, set);
    }

    public int getParent(int v){
        Node edge = disjoint_set.get(v);
        return getParent(edge).data;
    }

    private Node getParent(Node v){
        if(v.parent == v){
            return v;
        }

//        COMPRESSION
        Node parent = getParent(v.parent);
        v.parent = parent;

        return parent;
    }

    public void union(int v1 , int v2){
        Node n1 = disjoint_set.get(v1);
        Node n2 = disjoint_set.get(v2);

        Node parent_of_n1 = getParent(n1);
        Node parent_of_n2 = getParent(n2);

        if(parent_of_n1.rank == parent_of_n2.rank){
            parent_of_n2.parent = parent_of_n1;
            parent_of_n1.rank++;
        }
        else if (parent_of_n1.rank > parent_of_n2.rank) {
            parent_of_n2.parent = parent_of_n1;
        }
        else{
            parent_of_n1.parent = parent_of_n1;
        }
    }
}
