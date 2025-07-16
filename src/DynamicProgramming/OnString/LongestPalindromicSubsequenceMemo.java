package DynamicProgramming.OnString;

public class LongestPalindromicSubsequenceMemo {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return lcs(s, rev, n - 1, n - 1, dp);
    }

    private int lcs(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(
                    lcs(s1, s2, i - 1, j, dp),
                    lcs(s1, s2, i, j - 1, dp)
            );
        }
        return dp[i][j];
    }
}
