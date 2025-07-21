package DynamicProgramming.OnSquares;

public class PartitionArrayMaximumSumMemo {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return helper(0, arr, k, dp);
    }
    private int helper(int index, int[] arr, int k, Integer[] dp) {
        if (index == arr.length) return 0;
        if (dp[index] != null) return dp[index];

        int max = Integer.MIN_VALUE;
        int maxSum = 0;

        for (int j = index; j < Math.min(arr.length, index + k); j++) {
            max = Math.max(max, arr[j]);
            int length = j - index + 1;
            int total = max * length + helper(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, total);
        }
        return dp[index] = maxSum;
    }
}
