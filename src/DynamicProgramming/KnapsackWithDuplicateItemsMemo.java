package DynamicProgramming;

import java.util.Arrays;

public class KnapsackWithDuplicateItemsMemo {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(n - 1, capacity, val, wt, dp);
    }
    public static int helper(int i, int w, int[] val, int[] wt, int[][] dp) {
        if (i == 0) {
            return (w / wt[0]) * val[0];
        }

        if (dp[i][w] != -1) return dp[i][w];

        int notTake = helper(i - 1, w, val, wt, dp);
        int take = 0;
        if (wt[i] <= w)
            take = val[i] + helper(i, w - wt[i], val, wt, dp);

        return dp[i][w] = Math.max(take, notTake);
    }
}
