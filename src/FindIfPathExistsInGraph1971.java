import java.util.ArrayList;

public class FindIfPathExistsInGraph1971 {
    static boolean isPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited){
        if(src==dest) return true;

        visited[src] = true;

        for(int nbr: graph[src]){
            if(visited[nbr]==false){
                if(isPath(graph, nbr, dest, visited)==true){
                    return true;
                }
            }
        }

        return false;
    }
    static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        boolean[] visited = new boolean[n];

        return isPath(graph, source, destination, visited);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0, destination = 2;

        boolean flag = validPath(n, edges, source, destination);

        System.out.println("Whether Path exists : " +flag);

    }
}
