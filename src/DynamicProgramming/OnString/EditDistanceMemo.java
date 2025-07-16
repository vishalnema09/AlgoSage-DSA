package DynamicProgramming.OnString;

public class EditDistanceMemo {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        Integer[][] dp = new Integer[n][m];
        return solve(n - 1, m - 1, word1, word2, dp);
    }
    private int solve(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = solve(i - 1, j - 1, s1, s2, dp);
        } else {
            int insert = 1 + solve(i, j - 1, s1, s2, dp);
            int delete = 1 + solve(i - 1, j, s1, s2, dp);
            int replace = 1 + solve(i - 1, j - 1, s1, s2, dp);
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
