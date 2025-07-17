package DynamicProgramming.OnStocks;

import java.util.Arrays;

public class BestTimeBuySellStockTransactionFeeMemo {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, 1, prices, fee, dp);
    }

    private int helper(int i, int canBuy, int[] prices, int fee, int[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[i] + helper(i + 1, 0, prices, fee, dp);
            int skip = helper(i + 1, 1, prices, fee, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] - fee + helper(i + 1, 1, prices, fee, dp);
            int hold = helper(i + 1, 0, prices, fee, dp);
            profit = Math.max(sell, hold);
        }
        return dp[i][canBuy] = profit;
    }
}
