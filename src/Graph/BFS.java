package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
//                graph.removeEdge(4, 5);
        graph.display();
        System.out.println(graph.numberOfEdges());
        System.out.println(hasPath(graph.getGraph() , 1 , 6));
    }

    public static boolean hasPath(HashMap<Integer ,HashMap<Integer , Integer>> graph , int src , int des){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        HashSet<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()){

            int current = queue.remove();

//            IF VISITED
            if(visited.contains(current)){
                continue;
            }

//            MARK VISITED
            visited.add(current);

//            CHECK IF THE CURRENT IS EQUAL TO THE DESTINATION OR NOT
            if(current == des){
                return true;
            }

//            ADD NEIGHBOURS
           for (int i : graph.get(current).keySet()){
               if(!visited.contains(i)){
                   queue.add(i);
               }
           }
        }

        return false;
    }
}
