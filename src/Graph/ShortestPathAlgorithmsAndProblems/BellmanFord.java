package Graph.ShortestPathAlgorithmsAndProblems;

public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = (int) 1e8;
            }
        }

        return dist;
    }
}
