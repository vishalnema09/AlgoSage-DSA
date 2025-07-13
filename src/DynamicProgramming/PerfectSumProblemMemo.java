package DynamicProgramming;

public class PerfectSumProblemMemo {
    int mod = 1000000007;
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][target + 1];
        return countSubsets(n - 1, target, nums, dp);
    }
    public int countSubsets(int i, int target, int[] nums, Integer[][] dp) {
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2; // {} and {0}
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[i][target] != null) return dp[i][target];

        int notPick = countSubsets(i - 1, target, nums, dp);
        int pick = 0;
        if (nums[i] <= target)
            pick = countSubsets(i - 1, target - nums[i], nums, dp);

        return dp[i][target] = (pick + notPick) % mod;
    }
}
