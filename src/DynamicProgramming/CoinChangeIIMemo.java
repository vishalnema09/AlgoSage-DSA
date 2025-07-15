package DynamicProgramming;

public class CoinChangeIIMemo {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return helper(n - 1, amount, coins, dp);
    }

    private int helper(int i, int amt, int[] coins, Integer[][] dp) {
        if (i == 0) {
            if (amt % coins[0] == 0) return 1;
            else return 0;
        }

        if (dp[i][amt] != null) return dp[i][amt];

        int notTake = helper(i - 1, amt, coins, dp);
        int take = 0;
        if (coins[i] <= amt)
            take = helper(i, amt - coins[i], coins, dp);
        return dp[i][amt] = take + notTake;
    }
}
