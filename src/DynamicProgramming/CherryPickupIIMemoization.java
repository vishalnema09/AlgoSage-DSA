package DynamicProgramming;

import java.util.Arrays;

public class CherryPickupIIMemoization {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return helper(0, 0, n - 1, grid, dp);
    }

    private int helper(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        int m = grid.length, n = grid[0].length;

        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) return 0;

        if (dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int result = 0;
        if (col1 == col2)
            result = grid[row][col1];
        else
            result = grid[row][col1] + grid[row][col2];

        if (row < m - 1) {
            int max = 0;
            for (int d1 = -1; d1 <= 1; d1++) {
                for (int d2 = -1; d2 <= 1; d2++) {
                    max = Math.max(max, helper(row + 1, col1 + d1, col2 + d2, grid, dp));
                }
            }
            result += max;
        }
        return dp[row][col1][col2] = result;
    }
}
