package Graph;
import java.util.*;

public class CycleDetectionInUndirectedGraphByBFS {
    public boolean isCycle(int V, int[][] edges) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected
        }

        // Step 2: Visited array
        boolean[] visited = new boolean[V];

        // Step 3: Check every component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle
    }

    private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Already visited and not parent → cycle
                    return true;
                }
            }
        }

        return false;
    }
}
