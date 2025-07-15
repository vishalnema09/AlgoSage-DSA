package DynamicProgramming;

public class TargetSumTabular {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((total + target) < 0 || (total + target) % 2 != 0) return 0;

        int sum = (total + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n][sum + 1];

        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= sum) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= sum; s++) {
                int notPick = dp[i - 1][s];
                int pick = 0;
                if (nums[i] <= s)
                    pick = dp[i - 1][s - nums[i]];
                dp[i][s] = pick + notPick;
            }
        }
        return dp[n - 1][sum];
    }
}
