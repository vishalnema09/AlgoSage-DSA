package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            curr[1] = Math.max(-prices[i] + ahead[0], ahead[1]); // buy
            curr[0] = Math.max(prices[i] + ahead[1], ahead[0]);  // sell

            ahead = curr.clone();
        }
        return ahead[1];
    }
}
