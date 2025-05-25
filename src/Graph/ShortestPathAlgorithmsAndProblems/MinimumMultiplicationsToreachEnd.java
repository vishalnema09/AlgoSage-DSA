package Graph.ShortestPathAlgorithmsAndProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToreachEnd {
    class Pair {
        int steps, num;
        Pair(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }
    public int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;

        // Distance array to store minimum steps to reach each number
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // Initialize
        dist[start] = 0;
        q.offer(new Pair(0, start));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int steps = current.steps;
            int num = current.num;

            // If we've reached the target
            if (num == end) return steps;

            // Try all multipliers
            for (int mult : arr) {
                int newNum = (num * mult) % mod;

                // If this path gives fewer steps
                if (steps + 1 < dist[newNum]) {
                    dist[newNum] = steps + 1;
                    q.offer(new Pair(steps + 1, newNum));
                }
            }
        }

        // If end is not reachable
        return -1;
    }
}
