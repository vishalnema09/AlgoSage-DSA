package DynamicProgramming;

public class SubsetSumProblemMemo {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];

        return helper(n - 1, target, arr, dp);
    }

    private boolean helper(int i, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[0] == target;

        if (dp[i][target] != null) return dp[i][target];

        boolean notPick = helper(i - 1, target, arr, dp);

        boolean pick = false;
        if (arr[i] <= target)
            pick = helper(i - 1, target - arr[i], arr, dp);

        return dp[i][target] = pick || notPick;

    }
}
