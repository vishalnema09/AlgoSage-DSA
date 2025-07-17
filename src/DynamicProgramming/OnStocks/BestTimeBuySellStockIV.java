package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] next = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int trans = 2 * k - 1; trans >= 0; trans--) {
                if (trans % 2 == 0) {
                    curr[trans] = Math.max(-prices[index] + next[trans + 1], next[trans]);
                } else {
                    curr[trans] = Math.max(prices[index] + next[trans + 1], next[trans]);
                }
            }
            next = curr.clone();
        }
        return next[0];
    }
}
