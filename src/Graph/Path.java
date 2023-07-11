package Graph;

import java.util.HashSet;

public class Path {
    public static void main(String[] args) {
        GRAPH graph = new GRAPH(7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 4);
        graph.addEdge(7, 5, 2);
        graph.addEdge(6, 7, 3);
        graph.display();
        System.out.println(graph.numberOfEdges());
//        graph.removeEdge(4, 5);
//        graph.display();
//        System.out.println(graph.numberOfEdges());
//        System.out.println(hasPath(1 , 6  ,graph , new HashSet<>()));
        allPaths(1 , 6 , graph , new HashSet<>() , "");
    }

    static boolean hasPath(int source , int destination , GRAPH graph , HashSet<Integer> visited){
        if(source == destination){
            return true;
        }

        visited.add(source);
        for (int i : graph.Graph.get(source).keySet()){
            if(!visited.contains(i)){
                boolean ans = hasPath(i , destination , graph , visited);
                if (ans){
                    return true;
                }
            }
        }

        return false;
    }

    static void allPaths(int source , int destination , GRAPH graph , HashSet<Integer> visited , String ans){

        if(source == destination){
            System.out.println(ans + destination);
        }
        visited.add(source);
        for (int i : graph.Graph.get(source).keySet()){
            if(!visited.contains(i)){
                allPaths(i , destination , graph , visited , ans + source + "->" + "COST-" + graph.Graph.get(source).get(i) + "-->");
            }
        }
        visited.remove(source);
    }
}
