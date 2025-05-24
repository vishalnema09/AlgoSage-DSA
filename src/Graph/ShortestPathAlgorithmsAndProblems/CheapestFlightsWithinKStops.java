package Graph.ShortestPathAlgorithmsAndProblems;
import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});  // cost, city, stops

        int[][] visited = new int[n][k + 2];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if (city == dst) return cost;

            if (stops > k) continue;

            if (graph.containsKey(city)) {
                for (int[] nei : graph.get(city)) {
                    int nextCity = nei[0];
                    int price = nei[1];
                    int newCost = cost + price;

                    if (visited[nextCity][stops + 1] > newCost) {
                        visited[nextCity][stops + 1] = newCost;
                        pq.offer(new int[]{newCost, nextCity, stops + 1});
                    }
                }
            }
        }
        return -1;
    }
}
