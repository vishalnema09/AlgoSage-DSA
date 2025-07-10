package DynamicProgramming;

public class HouseRobberIITabular {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int case1 = solveTab(nums, 0, n - 2);

        int case2 = solveTab(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int solveTab(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = nums[start];

        for(int i = 1; i < len; i++) {
            int pick = nums[start + i];
            if(i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[len - 1];
    }
}
