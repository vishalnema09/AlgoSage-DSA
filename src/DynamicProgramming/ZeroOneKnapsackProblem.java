package DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsackProblem {
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, W, wt, val, dp);
    }
    private static int helper(int i, int w, int[] wt, int[] val, int[][] dp) {
        if (i == 0) {
            if (wt[0] <= w) return val[0];
            return 0;
        }

        if (dp[i][w] != -1) return dp[i][w];

        int notPick = helper(i - 1, w, wt, val, dp);
        int pick = 0;
        if (wt[i] <= w)
            pick = val[i] + helper(i - 1, w - wt[i], wt, val, dp);

        return dp[i][w] = Math.max(pick, notPick);
    }
}
