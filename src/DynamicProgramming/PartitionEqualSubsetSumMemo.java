package DynamicProgramming;

public class PartitionEqualSubsetSumMemo {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums)sum+=num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];

        return helper(n - 1, target, nums, dp);
    }
    private boolean helper(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == 0) return nums[0] == target;

        if (dp[i][target] != null) return dp[i][target];

        boolean notPick = helper(i - 1, target, nums, dp);
        boolean pick = false;

        if (nums[i] <= target) {
            pick = helper(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = pick || notPick;
    }
}
