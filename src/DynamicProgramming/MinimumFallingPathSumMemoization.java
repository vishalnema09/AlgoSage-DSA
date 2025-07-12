package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSumMemoization {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int min = Integer.MAX_VALUE;

        // Try all starting points in top row
        for (int j = 0; j < n; j++) {
            min = Math.min(min, helper(0, j, matrix, dp));
        }

        return min;
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        // Out of bounds
        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        // Base case: bottom row
        if (i == n - 1) return matrix[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int down = helper(i + 1, j, matrix, dp);
        int left = helper(i + 1, j - 1, matrix, dp);
        int right = helper(i + 1, j + 1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
    }
}
