package Graph.LEVELUP;

import java.util.*;

/*
Given a list of processes where each process have a unique id and a unique parent id . Parent id is the id of the process
that initiated that process . You want to kill a particular process given by an integer kill . Print id of all the processes
that will be killed to kill that process.You should print them in sorted order by id.
In order to kill a process , all its child processes should be killed as well . Also, only one process have parent id as 0 i.e.
that process started itself.

Input Format
The first line contains two integer - n (number of process ) and k (id of process to be killed).
Next line contains n integer equal to id of ith process.
Next line contains n integer equal to parent id of ith process.

Constraints
1<=n<=10^5

Output Format
Print id of all the process that will be killed in sorted order.

Sample Input
3 2
1 2 3
0 1 1
Sample Output
2
Explanation
Since , process with id 2 have no child , so it will only be killed.
*/
public class Kill_Process {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int id = sc.nextInt();
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr[1][i] = sc.nextInt();
        }

        HashMap<Integer , HashSet<Integer>> graph = createGraph(arr);
        System.out.println(count_killing_process(id , graph));
    }

    private static int count_killing_process(int id , HashMap<Integer , HashSet<Integer>> graph){
        int count = 1;

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()){
            int curr = queue.remove();

            if(visited.contains(curr)){
                continue;
            }

            visited.add(curr);
            count++;

            for (int nbh : graph.get(curr)){
                if(!visited.contains(nbh)){
                    queue.add(nbh);
                }
            }
        }

        return count;
    }

    private static HashMap<Integer , HashSet<Integer>> createGraph(int[][] arr){
        HashMap<Integer , HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0 ; i <= arr[0].length ; i++){
            graph.put(i , new HashSet<>());
        }


        for (int[] a : arr){
            int v1 = a[0];
            int v2 = a[1];

            graph.get(v1).add(v2);
        }

        return graph;
    }
}
