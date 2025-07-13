package DynamicProgramming;

public class PartitionEqualSubsetSumTab {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notPick = dp[i - 1][t];
                boolean pick = false;
                if (nums[i] <= t) {
                    pick = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}
