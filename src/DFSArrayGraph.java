public class DFSArrayGraph {
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        visited = new boolean[graph.length];
        dfs(graph, 0);
    }

    static void dfs(int[][] graph, int start){
        visited[start] = true;
        System.out.println(start + " ");
        for (int i = 0; i < graph.length; i++) {
            if(graph[start][i]==1 && !visited[i]) {
                visited[i] = true;
                dfs(graph, i);
            }
        }
    }


}
