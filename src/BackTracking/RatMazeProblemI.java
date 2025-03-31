package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatMazeProblemI {
    class Solution {
        public void findPaths(int r, int c, ArrayList<ArrayList<Integer>> mat, int n,
                              String path, ArrayList<String> ans, boolean[][] visited) {

            if (r < 0 || c < 0 || r >= n || c >= n || mat.get(r).get(c) == 0 || visited[r][c]) {
                return;
            }

            if (r == n - 1 && c == n - 1) {
                ans.add(path);
                return;
            }

            visited[r][c] = true;

            findPaths(r + 1, c, mat, n, path + "D", ans, visited); // Down
            findPaths(r, c - 1, mat, n, path + "L", ans, visited); // Left
            findPaths(r, c + 1, mat, n, path + "R", ans, visited); // Right
            findPaths(r - 1, c, mat, n, path + "U", ans, visited); // Up

            visited[r][c] = false; // Backtrack
        }

        public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
            ArrayList<String> ans = new ArrayList<>();
            int n = mat.size();

            if (n == 0 || mat.get(0).get(0) == 0) {
                return ans;
            }

            boolean[][] visited = new boolean[n][n];
            findPaths(0, 0, mat, n, "", ans, visited);

            Collections.sort(ans);

            return ans;
        }
    }
}
