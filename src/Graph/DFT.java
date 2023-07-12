package Graph;

import java.util.*;

public class DFT {
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
//        graph.removeEdge(4, 5);
        graph.display();
        System.out.println(graph.numberOfEdges());
        depthFirstTraversal(graph.getGraph());
    }

    private static void depthFirstTraversal(HashMap<Integer, HashMap<Integer, Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        for (int ele : graph.keySet()) {

            if (visited.contains(ele)) {
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(ele);

            while (!stack.isEmpty()) {

                int current = stack.pop();

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
                        stack.push(i);
                    }
                }
            }
            System.out.println();
        }
    }
}
