package Graph;

import java.util.HashMap;

public class GRAPH {
    private HashMap<Integer , HashMap<Integer , Integer>> Graph;

    public GRAPH(int vertex){
        Graph = new HashMap<>();
        for (int i = 1 ; i <= vertex ; i++){
            Graph.put(i , new HashMap<>());
        }
    }

//    CONNECT TWO EDGES WITH THE COST
    public void addEdge(int v1 , int v2 , int cost){
        Graph.get(v1).put(v2 , cost);
        Graph.get(v2).put(v1 , cost);
    }

//    CHECK IF TWO EDGES ARE CONNECTED OR NOT
    public boolean containsEdge(int v1 , int v2){
        return Graph.get(v1).containsKey(v2) && Graph.get(v2).containsKey(v1);
    }

//    CHECK IF VERTEX IS PRESENT OR NOT
    public boolean containsVertex(int v){
        return Graph.containsKey(v);
    }

//    CALCULATE THE NUMBER OF EDGES
    public int numberOfEdges(){
        int total = 0;
        for (int i : Graph.keySet()){
            total += Graph.get(i).size();
        }
        return total / 2;
    }

//    REMOVE THE EDGE BETWEEN TOW VERTEX
    public void removeEdge(int v1 , int v2){
        if(containsEdge(v1 , v2)){
            Graph.get(v1).remove(v2);
            Graph.get(v2).remove(v1);
        }
    }

//    REMOVE VERTEX
    public void removeVertex(int v){
//        FIRST REMOVE ALL THE CONNECTIONS FROM THE VERTEXES CONNECTED TO THE VERTEX TO BE DELETED
        for (int i : Graph.get(v).keySet()){
            Graph.get(i).remove(v);
        }
        Graph.remove(v);
    }

    public void display(){
        for (int i : Graph.keySet()){
            System.out.println(i + "->" + Graph.get(i));
        }
    }

}
