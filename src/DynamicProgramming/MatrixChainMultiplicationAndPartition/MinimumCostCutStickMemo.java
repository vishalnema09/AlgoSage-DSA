package DynamicProgramming.MatrixChainMultiplicationAndPartition;

import java.util.Arrays;

public class MinimumCostCutStickMemo {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;

        for(int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(1, c, newCuts, dp);
    }

    private int helper(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                    + helper(i, k - 1, cuts, dp)
                    + helper(k + 1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
