package DynamicProgramming;

public class ZeroOneKnapsackProblemTab {
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];

        for (int w = wt[0]; w <= W; w++) {
            dp[0][w] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int notPick = dp[i - 1][w];
                int pick = 0;
                if (wt[i] <= w)
                    pick = val[i] + dp[i - 1][w - wt[i]];

                dp[i][w] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][W];
    }
}
