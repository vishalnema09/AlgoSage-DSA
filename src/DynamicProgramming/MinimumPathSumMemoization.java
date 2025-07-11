package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSumMemoization {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return findMinSum(m - 1, n - 1, grid, dp);
    }

    private int findMinSum(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        int up = findMinSum(i - 1, j, grid, dp);
        int left = findMinSum(i, j - 1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}
