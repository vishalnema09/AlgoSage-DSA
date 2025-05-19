package Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraphByDFS {
    public boolean isCyclic(int V, int[][] edges) {
        // Step 1: Convert edges to adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // Directed edge u -> v
        }

        // Step 2: Visited arrays
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        // Step 3: Traverse all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) return true;
            } else if (pathVisited[neighbor]) {
                return true; // Cycle detected
            }
        }

        pathVisited[node] = false; // Backtrack
        return false;
    }
}
