package DynamicProgramming;

public class PerfectSumProblemTab {
    int mod = 1000000007;

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= target)
                dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notPick = dp[i - 1][t];
                int pick = 0;
                if (nums[i] <= t)
                    pick = dp[i - 1][t - nums[i]];

                dp[i][t] = (pick + notPick) % mod;
            }
        }
        return dp[n - 1][target];
    }
}
