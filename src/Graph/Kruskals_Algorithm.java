package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Kruskals_Algorithm {
    public HashMap<Integer , HashMap<Integer , Integer>> Graph;

    public Kruskals_Algorithm(int v){
        Graph = new HashMap<>();
        for (int i = 1 ; i <= v ; i++){
            Graph.put(i , new HashMap<>());
        }
    }

    public void addEdge(int v1 , int v2 , int cost){
        Graph.get(v1).put(v2 , cost);
        Graph.get(v2).put(v1 , cost);
    }

    class EdgePair{
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1 , int e2 , int cost){
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
    }

    public ArrayList<EdgePair> getalledge() {
        ArrayList<EdgePair> list = new ArrayList<>();

        for (int e1 : Graph.keySet()) {
            for (int e2 : Graph.get(e1).keySet()) {

                EdgePair eg = new EdgePair(e1, e2, Graph.get(e1).get(e2));
                list.add(eg);

            }

        }
        return list;
    }

    public void KruskalsAlgorithm() {
        int ans = 0;
        Disjoint_set ds = new Disjoint_set();
        for (int k : Graph.keySet()) {
            ds.createSet(k);

        }
        ArrayList<EdgePair> ll = getalledge();
        Collections.sort(ll, new Comparator<EdgePair>() {

            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                return o1.cost - o2.cost;
            }
        });
        for (EdgePair edge : ll) {
            int e1 = edge.e1;
            int e2 = edge.e2;
            int re1 = ds.getParent(e1);
            int re2 = ds.getParent(e2);
            if (re1 != re2) {
                System.out.println(edge);
                ans += edge.cost;
                ds.union(re1, re2);
            }

        }
        System.out.println(ans);

    }

}
