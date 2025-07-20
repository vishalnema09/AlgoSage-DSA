package DynamicProgramming.MatrixChainMultiplicationAndPartition;

import java.util.Arrays;

public class BurstBalloonsMemo {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for (int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, n, newNums, dp);
    }

    private int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for (int k = i; k <= j; k++) {
            int coins = nums[i - 1] * nums[k] * nums[j + 1]
                    + solve(i, k - 1, nums, dp)
                    + solve(k + 1, j, nums, dp);
            max = Math.max(max, coins);
        }
        return dp[i][j] = max;
    }
}
