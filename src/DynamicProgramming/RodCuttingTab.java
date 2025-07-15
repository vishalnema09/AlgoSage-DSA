package DynamicProgramming;

public class RodCuttingTab {
    public int cutRod(int[] price) {
        int N = price.length;
        int[][] dp = new int[N][N + 1];

        for (int len = 0; len <= N; len++) {
            dp[0][len] = len * price[0];
        }

        for (int i = 1; i < N; i++) {
            int rodLen = i + 1;
            for (int len = 0; len <= N; len++) {
                int notTake = dp[i - 1][len];
                int take = 0;
                if (rodLen <= len)
                    take = price[i] + dp[i][len - rodLen];
                dp[i][len] = Math.max(take, notTake);
            }
        }
        return dp[N - 1][N];
    }
}
