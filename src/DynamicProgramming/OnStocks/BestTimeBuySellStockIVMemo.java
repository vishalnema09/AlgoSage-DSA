package DynamicProgramming.OnStocks;

import java.util.Arrays;

public class BestTimeBuySellStockIVMemo {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, k * 2, prices, dp);
    }

    public int helper(int index, int trans, int maxTrans, int[] prices, int[][] dp) {
        if (index == prices.length || trans == maxTrans)
            return 0;
        if (dp[index][trans] != -1)
            return dp[index][trans];

        int profit = 0;
        if (trans % 2 == 0) {
            profit = Math.max(-prices[index] + helper(index + 1, trans + 1, maxTrans, prices, dp),
                    helper(index + 1, trans, maxTrans, prices, dp));
        } else {
            profit = Math.max(prices[index] + helper(index + 1, trans + 1, maxTrans, prices, dp),
                    helper(index + 1, trans, maxTrans, prices, dp));
        }

        return dp[index][trans] = profit;
    }
}
