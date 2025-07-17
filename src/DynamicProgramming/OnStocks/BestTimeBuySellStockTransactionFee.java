package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int aheadBuy = 0, aheadNotBuy = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            int currNotBuy = Math.max(prices[i] - fee + aheadBuy, aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
