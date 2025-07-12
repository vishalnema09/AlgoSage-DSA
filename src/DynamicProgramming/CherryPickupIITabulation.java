package DynamicProgramming;

public class CherryPickupIITabulation {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 == col2)
                    dp[m - 1][col1][col2] = grid[m - 1][col1];
                else
                    dp[m - 1][col1][col2] = grid[m - 1][col1] + grid[m - 1][col2];
            }
        }
        for (int row = m - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int max = 0;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int newCol1 = col1 + d1;
                            int newCol2 = col2 + d2;
                            if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                            }
                        }
                    }
                    if (col1 == col2)
                        dp[row][col1][col2] = grid[row][col1] + max;
                    else
                        dp[row][col1][col2] = grid[row][col1] + grid[row][col2] + max;
                }
            }
        }
        return dp[0][0][n - 1];
    }
}
