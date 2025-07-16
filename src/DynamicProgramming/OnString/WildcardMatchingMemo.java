package DynamicProgramming.OnString;

public class WildcardMatchingMemo {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return match(n, m, s, p, dp);
    }
    private boolean match(int i, int j, String s, String p, Boolean[][] dp) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;
        if (i == 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
            dp[i][j] = match(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j - 1) == '*') {
            dp[i][j] = match(i - 1, j, s, p, dp) || match(i, j - 1, s, p, dp);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}
