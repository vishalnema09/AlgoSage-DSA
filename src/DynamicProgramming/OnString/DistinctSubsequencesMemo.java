package DynamicProgramming.OnString;

public class DistinctSubsequencesMemo {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        Integer[][] dp = new Integer[n][m];
        return countWays(s, t, n - 1, m - 1, dp);
    }

    private int countWays(String s, String t, int i, int j, Integer[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = countWays(s, t, i - 1, j - 1, dp) + countWays(s, t, i - 1, j, dp);
        } else {
            dp[i][j] = countWays(s, t, i - 1, j, dp);
        }
        return dp[i][j];
    }
}
