package DynamicProgramming;

public class TargetSumMemo {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if (target > total || (total + target) % 2 == 1) return 0;

        int sum = (total + target) / 2;
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return countSubsets(nums.length - 1, sum, nums, dp);
    }

    private int countSubsets(int i, int sum, int[] nums, Integer[][] dp) {
        if (i == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }

        if (dp[i][sum] != null) return dp[i][sum];

        int notPick = countSubsets(i - 1, sum, nums, dp);
        int pick = 0;
        if (nums[i] <= sum)
            pick = countSubsets(i - 1, sum - nums[i], nums, dp);

        return dp[i][sum] = pick + notPick;
    }
}
