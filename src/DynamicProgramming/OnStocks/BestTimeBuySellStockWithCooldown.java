package DynamicProgramming.OnStocks;

public class BestTimeBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy = 0, aheadNotBuy = 0;
        int ahead2Buy = 0, ahead2NotBuy = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            int currNotBuy = Math.max(prices[i] + ahead2Buy, aheadNotBuy);
            ahead2Buy = aheadBuy;
            ahead2NotBuy = aheadNotBuy;
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
