package DynamicProgramming.OnStocks;

import java.util.Arrays;

public class BestTimeBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 1, prices, dp);
    }
    int helper(int i, int buy, int[] prices, int[][] dp) {
        if (i >= prices.length) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if (buy == 1) {
            int buyNow = -prices[i] + helper(i + 1, 0, prices, dp);
            int skip = helper(i + 1, 1, prices, dp);
            profit = Math.max(buyNow, skip);
        } else {
            int sellNow = prices[i] + helper(i + 2, 1, prices, dp);
            int skip = helper(i + 1, 0, prices, dp);
            profit = Math.max(sellNow, skip);
        }
        return dp[i][buy] = profit;
    }
}
