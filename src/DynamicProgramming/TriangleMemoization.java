package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class TriangleMemoization {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, 0, triangle, dp);
    }
    private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) return dp[i][j];
        int down = helper(i + 1, j, triangle, dp);
        int diagonal = helper(i + 1, j + 1, triangle, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}
