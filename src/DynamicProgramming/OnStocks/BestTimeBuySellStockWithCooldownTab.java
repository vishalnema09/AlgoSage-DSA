package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockWithCooldownTab {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int buyNow = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    dp[i][buy] = Math.max(buyNow, skip);
                } else {
                    int sellNow = prices[i] + dp[i + 2][1];
                    int skip = dp[i + 1][0];
                    dp[i][buy] = Math.max(sellNow, skip);
                }
            }
        }
        return dp[0][1];
    }
}
