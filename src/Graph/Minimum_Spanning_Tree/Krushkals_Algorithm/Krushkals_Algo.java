package Graph.Minimum_Spanning_Tree.Krushkals_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Krushkals_Algo {

    private HashMap<Integer , HashMap<Integer , Integer>> map;

    public Krushkals_Algo(int v){
        this.map = new HashMap<>();
        for (int i = 1 ; i <= v ; i++){
            this.map.put(i , new HashMap<>());
        }
    }

    public void addEdge(int v1 , int v2 , int cost){
        this.map.get(v1).put(v2 , cost);
        this.map.get(v2).put(v1 , cost);
    }

    private class EdgePair{
        int v1;
        int v2;
        int cost;
        public  EdgePair(int v1 , int v2 , int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    private ArrayList<EdgePair> getAllEdgePair(){
        ArrayList<EdgePair> list = new ArrayList<>();
        for (int v1 : this.map.keySet()){
            for (int v2 : this.map.get(v1).keySet()){
                EdgePair pair = new EdgePair(v1 , v2 , this.map.get(v1).get(v2));
                list.add(pair);
            }
        }

        return list;
    }

    public int KrushkalsAlgo(){

//        CREATE SETS OF ALL EDGE
        Disjoint_set set = new Disjoint_set();
        for (int v : this.map.keySet()){
            set.createSet(v);
        }

        ArrayList<EdgePair> allEdges = getAllEdgePair();

//        SORT THEM
        Collections.sort(allEdges, new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                return o1.cost - o2.cost;
            }
        });

        int ans = 0;
        for (EdgePair edge : allEdges){
            int v1 = edge.v1;
            int v2 = edge.v2;

            int parent_of_v1 = set.getParent(v1);
            int parent_of_v2 = set.getParent(v2);

            if(parent_of_v1 != parent_of_v2){
                set.union(v1 , v2);
                ans += edge.cost;
            }
        }

        return ans;
    }

}
