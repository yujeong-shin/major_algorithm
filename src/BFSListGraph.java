import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args){
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5;
        visited = new boolean[node_n];
        adjList = new ArrayList<>();
        for (int i = 0; i < node_n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] input : inputArr) {
            addEdge(input[0], input[1]);
        }
        distance = new int[node_n];
        System.out.println(distance[4]);

        bfs(0);
    }
    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int next = queue.poll();
//            System.out.println(next + " ");
            for(int target : adjList.get(next)){
                if(!visited[target]){
                    visited[target]=true;
                    distance[target] = distance[next]+1;
                    queue.add(target);
                }
            }
        }
    }
}
