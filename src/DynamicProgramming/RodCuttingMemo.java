package DynamicProgramming;

import java.util.Arrays;

public class RodCuttingMemo {
    public int cutRod(int[] price) {
        int N = price.length;
        int[][] dp = new int[N][N + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(N - 1, N, price, dp);
    }

    private int helper(int i, int len, int[] price, int[][] dp) {
        if (i == 0) {
            return len * price[0];
        }

        if (dp[i][len] != -1) return dp[i][len];

        int notTake = helper(i - 1, len, price, dp);
        int take = 0;
        int rodLen = i + 1;

        if (rodLen <= len)
            take = price[i] + helper(i, len - rodLen, price, dp);

        return dp[i][len] = Math.max(take, notTake);
    }
}
