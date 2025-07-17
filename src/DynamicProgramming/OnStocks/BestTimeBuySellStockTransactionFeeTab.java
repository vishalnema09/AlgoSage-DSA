package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockTransactionFeeTab {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    int buy = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices[i] - fee + dp[i + 1][1];
                    int hold = dp[i + 1][0];
                    profit = Math.max(sell, hold);
                }
                dp[i][canBuy] = profit;
            }
        }
        return dp[0][1];
    }
}
