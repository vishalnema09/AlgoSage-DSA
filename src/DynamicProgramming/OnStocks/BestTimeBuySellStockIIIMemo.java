package DynamicProgramming.OnStocks;

import java.util.Arrays;

public class BestTimeBuySellStockIIIMemo {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int[][] row : dp)
            for (int[] inner : row)
                Arrays.fill(inner, -1);

        return helper(0, 1, 2, prices, dp);
    }
    private int helper(int idx, int canBuy, int cap, int[] prices, int[][][] dp) {
        if (idx == prices.length || cap == 0) return 0;

        if (dp[idx][canBuy][cap] != -1) return dp[idx][canBuy][cap];

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[idx] + helper(idx + 1, 0, cap, prices, dp),
                    helper(idx + 1, 1, cap, prices, dp)
            );
        } else {
            profit = Math.max(
                    prices[idx] + helper(idx + 1, 1, cap - 1, prices, dp),
                    helper(idx + 1, 0, cap, prices, dp)
            );
        }
        return dp[idx][canBuy][cap] = profit;
    }
}
