package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockIITab {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    dp[i][canBuy] = Math.max(-prices[i] + dp[i + 1][0],
                            dp[i + 1][1]);
                } else {
                    dp[i][canBuy] = Math.max(prices[i] + dp[i + 1][1],
                            dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
