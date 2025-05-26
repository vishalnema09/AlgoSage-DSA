package Graph.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetByRank {
    static class DSU {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        // Constructor
        public DSU(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i); // Initially each node is its own parent
                rank.add(0);   // Rank of each node is 0
            }
        }

        // Find with path compression
        public int find(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int root = find(parent.get(node));
            parent.set(node, root); // Path compression
            return root;
        }

        // Union by rank
        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) return; // Already in same set

            if (rank.get(parentU) < rank.get(parentV)) {
                parent.set(parentU, parentV);
            } else if (rank.get(parentV) < rank.get(parentU)) {
                parent.set(parentV, parentU);
            } else {
                parent.set(parentV, parentU);
                rank.set(parentU, rank.get(parentU) + 1);
            }
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(7); // We have 7 nodes from 1 to 7

        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(6, 7);
        dsu.union(5, 6);

        // Check if 3 and 7 are in the same component
        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Now union 3 and 7, then check again
        dsu.union(3, 7);

        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
