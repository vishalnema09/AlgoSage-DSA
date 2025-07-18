package DynamicProgramming.OnLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequenceMemo {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, -1, nums, dp);
    }
    private int helper(int i, int prevIndex, int[] nums, int[][] dp) {
        if (i == nums.length) return 0;
        if (dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];
        int notTake = helper(i + 1, prevIndex, nums, dp);
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + helper(i + 1, i, nums, dp);
        }
        return dp[i][prevIndex + 1] = Math.max(take, notTake);
    }
}
