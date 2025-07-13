package DynamicProgramming;

public class SubsetSumProblemTab {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notPick = dp[i - 1][t];
                boolean pick = false;
                if (arr[i] <= t)
                    pick = dp[i - 1][t - arr[i]];

                dp[i][t] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}
