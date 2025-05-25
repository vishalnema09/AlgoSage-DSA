package Graph.ShortestPathAlgorithmsAndProblems;
import java.util.*;
public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});  // {distance, node}

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long time = current[0];
            int node = (int) current[1];

            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long edgeTime = neighbor[1];

                if (time + edgeTime < dist[nextNode]) {
                    dist[nextNode] = time + edgeTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if (time + edgeTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
