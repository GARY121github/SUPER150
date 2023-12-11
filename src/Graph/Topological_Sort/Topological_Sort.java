package Graph.Topological_Sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort {
    private HashMap<Integer , HashMap<Integer , Integer>> map;

    public Topological_Sort(int v){
        map = new HashMap<>();
        for (int i = 0 ; i < v ; i++){
            map.put(i , new HashMap<>());
        }
    }

    public void addEdge(int v1 , int v2){
        map.get(v1).put(v2 , 0);
    }

    public boolean TopologicalSort(){
        int[] arr = indegree();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int curr = queue.remove();
            count++;
            for (int nbrs : this.map.get(curr).keySet()){
                arr[nbrs]--;
                if(arr[nbrs] == 0){
                    queue.add(nbrs);
                }
            }
        }

        return count == this.map.size();
    }

    private int[] indegree(){
        int[] arr = new int[this.map.size()];

        for (int vtx : this.map.keySet()){
            for (int nbrs : this.map.get(vtx).keySet()){
                arr[nbrs]++;
            }
        }

        return arr;
    }
}
