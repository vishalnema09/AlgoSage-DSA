package DynamicProgramming;

public class PartitionsWithGivenDifferenceMemo {
    int mod = 1000000007;

    public int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        if ((total + d) % 2 != 0) return 0;
        int target = (total + d) / 2;

        Integer[][] dp = new Integer[n][target + 1];
        return countSubsets(n - 1, target, arr, dp);
    }

    private int countSubsets(int i, int target, int[] arr, Integer[][] dp) {
        if (i == 0) {
            if (target == 0 && arr[0] == 0) return 2; // {} and {0}
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[i][target] != null) return dp[i][target];

        int notPick = countSubsets(i - 1, target, arr, dp);
        int pick = 0;
        if (arr[i] <= target)
            pick = countSubsets(i - 1, target - arr[i], arr, dp);

        return dp[i][target] = (pick + notPick) % mod;
    }

}
