package Graph;

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
        graph.removeEdge(4, 5);
        graph.display();
        System.out.println(graph.numberOfEdges());
    }
}
