package Graph;

import java.util.HashMap;

public class Disjoint_set {
    class Node{
        int data;
        int rank;
        Node parent;
    }
    private HashMap<Integer , Node> map = new HashMap<>();

    public void createSet(int v){
        Node ob = new Node();
        ob.data = v;
        ob.rank = 0;
        ob.parent = ob;
        map.put(v , ob);
    }

    public int getParent(int v){
        Node node = map.get(v);
        return find(node).data;
    }

    public Node find(Node node){
        if(node.parent == node){
            return node;
        }

        return find(node.parent);
    }
    public void union(int v1 , int v2){
        Node n1 = map.get(v1);
        Node pn1 = find(n1);
        Node n2 = map.get(v2);
        Node pn2 = find(n2);

        if(pn1.rank == pn2.rank){
            pn2.parent = pn1;
            pn1.rank++;
        }
        else if(pn1.rank > pn2.rank){
            pn2.parent = pn1;
        }
        else {
            pn1.parent = pn2;
        }
    }
}
