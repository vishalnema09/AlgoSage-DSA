package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeMemo {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = helper(n - 1, amount, coins, dp);
        return (ans >= 1e9) ? -1 : ans;
    }

    private int helper(int i, int amt, int[] coins, int[][] dp) {
        if (i == 0) {
            if (amt % coins[0] == 0) return amt / coins[0];
            else return (int) 1e9;
        }

        if (dp[i][amt] != -1) return dp[i][amt];

        int notTake = helper(i - 1, amt, coins, dp);
        int take = (int) 1e9;
        if (coins[i] <= amt)
            take = 1 + helper(i, amt - coins[i], coins, dp);

        return dp[i][amt] = Math.min(take, notTake);
    }
}
