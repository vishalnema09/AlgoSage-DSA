package DynamicProgramming.MatrixChainMultiplicationAndPartition;

import java.util.Arrays;

public class MinimumCostCutStickTab {
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

        for (int len = 1; len <= c; len++) {
            for (int i = 1; i + len - 1 <= c; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1]
                            + dp[i][k - 1]
                            + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][c];
    }
}
