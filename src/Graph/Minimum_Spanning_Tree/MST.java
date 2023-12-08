package Graph.Minimum_Spanning_Tree;

import Graph.Minimum_Spanning_Tree.Krushkals_Algorithm.Krushkals_Algo;

import java.util.Scanner;

public class MST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Krushkals_Algo krushkals_algo = new Krushkals_Algo(n);
        int m = sc.nextInt();
        for (int i = 0 ; i < m ; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            krushkals_algo.addEdge(v1 , v2 , cost);
        }
        int ans = krushkals_algo.KrushkalsAlgo();
        System.out.println(ans);
    }
}
