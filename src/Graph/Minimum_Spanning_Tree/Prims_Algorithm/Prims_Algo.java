package Graph.Minimum_Spanning_Tree.Prims_Algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prims_Algo {
    private HashMap<Integer , HashMap<Integer , Integer>> map;

    public Prims_Algo(int v){
        this.map = new HashMap<>();

        for (int i = 1 ; i <= v ; i++){
            map.put(i , new HashMap<>());
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
        public EdgePair(int v1 , int v2 , int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    public int PrimsAlgo(){
        PriorityQueue<EdgePair> minHeap = new PriorityQueue<>(new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                return o1.cost - o2.cost;
            }
        });

        HashSet<Integer> visited = new HashSet<>();
        minHeap.add(new EdgePair(1 , 1 , 0));
        int ans = 0;
        while (!minHeap.isEmpty()){

//            remove
            EdgePair curr = minHeap.remove();

//            ignore
            if(visited.contains(curr.v1)){
                continue;
            }

//            mark visited
            visited.add(curr.v1);

//            calculate
            ans += curr.cost;

            for (int nbrs : map.get(curr.v1).keySet()){
                if(!visited.contains(nbrs)){
                    EdgePair pair = new EdgePair(nbrs , curr.v1 , map.get(curr.v1).get(nbrs));
                    minHeap.add(pair);
                }
            }
        }

        return ans;
    }
}
