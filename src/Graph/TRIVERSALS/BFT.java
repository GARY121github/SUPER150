package Graph.TRIVERSALS;

import Graph.GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFT {
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
                graph.removeEdge(4, 5);
        graph.display();
        System.out.println(graph.numberOfEdges());
        breathFirstTraversal(graph.getGraph());
    }

    private static void breathFirstTraversal(HashMap<Integer, HashMap<Integer, Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        for (int ele : graph.keySet()) {

            if (visited.contains(ele)) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(ele);
            while (!queue.isEmpty()) {

                int current = queue.remove();

//            IF VISITED
                if (visited.contains(current)) {
                    continue;
                }

//            MARK VISITED
                visited.add(current);

//           printing
                System.out.print(current + " -> ");

//            ADD NEIGHBOURS
                for (int i : graph.get(current).keySet()) {
                    if (!visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
            System.out.println();
        }
    }
}

