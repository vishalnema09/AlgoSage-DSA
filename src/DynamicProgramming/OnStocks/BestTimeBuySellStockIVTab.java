package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockIVTab {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int trans = 2 * k - 1; trans >= 0; trans--) {
                if (trans % 2 == 0) {
                    dp[index][trans] = Math.max(-prices[index] + dp[index + 1][trans + 1],
                            dp[index + 1][trans]);
                } else {
                    dp[index][trans] = Math.max(prices[index] + dp[index + 1][trans + 1],
                            dp[index + 1][trans]);
                }
            }
        }
        return dp[0][0];
    }
}
