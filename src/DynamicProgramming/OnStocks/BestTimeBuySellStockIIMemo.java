package DynamicProgramming.OnStocks;

import java.util.Arrays;

public class BestTimeBuySellStockIIMemo {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 1, prices, dp);
    }

    private int helper(int i, int canBuy, int[] prices, int[][] dp) {
        if (i == prices.length)
            return 0;

        if (dp[i][canBuy] != -1)
            return dp[i][canBuy];

        int profit;
        if (canBuy == 1) {
            profit = Math.max(-prices[i] + helper(i + 1, 0, prices, dp),
                    helper(i + 1, 1, prices, dp));
        } else {
            profit = Math.max(prices[i] + helper(i + 1, 1, prices, dp),
                    helper(i + 1, 0, prices, dp));
        }

        return dp[i][canBuy] = profit;
    }
}
