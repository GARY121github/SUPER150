package Graph.TRIVERSALS;

import Graph.GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DFS {
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

    private static boolean hasPath(HashMap<Integer , HashMap<Integer , Integer>> graph , int src , int des){
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.push(src);
        while (!stack.isEmpty()){
//            REMOVE
            int current = stack.pop();

//            IGNORE
            if(visited.contains(current)){
                continue;
            }

//            MARK VISITED
            visited.add(current);

//            CHECK IF WE HAVE REACHED THE DESTINATION OR NOT
            if(current == des){
                return true;
            }

//            ADD NEIGHBOURS
            for (int i : graph.get(current).keySet()) {
                if (!visited.contains(i)) {
                    stack.push(i);
                }
            }
        }
        return false;
    }
}
