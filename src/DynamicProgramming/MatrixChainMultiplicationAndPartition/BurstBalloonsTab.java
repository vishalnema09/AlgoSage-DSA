package DynamicProgramming.MatrixChainMultiplicationAndPartition;

public class BurstBalloonsTab {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int coins = newNums[i - 1] * newNums[k] * newNums[j + 1]
                            + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}
