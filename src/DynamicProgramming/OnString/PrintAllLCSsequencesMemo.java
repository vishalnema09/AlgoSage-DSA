package DynamicProgramming.OnString;

import java.util.HashSet;
import java.util.Set;

public class PrintAllLCSsequencesMemo {
    public Set<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        Integer[][] dp = new Integer[n + 1][m + 1];

        lcs(s1, s2, n, m, dp);

        Set<String> result = new HashSet<>();
        backtrack(s1, s2, n, m, dp, "", result);
        return result;
    }

    private int lcs(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = Math.max(
                lcs(s1, s2, i - 1, j, dp),
                lcs(s1, s2, i, j - 1, dp)
        );
    }

    private void backtrack(String s1, String s2, int i, int j, Integer[][] dp, String path, Set<String> result) {
        if (i == 0 || j == 0) {
            result.add(new StringBuilder(path).reverse().toString());
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            backtrack(s1, s2, i - 1, j - 1, dp, path + s1.charAt(i - 1), result);
        } else {
            if (dp[i - 1][j] != null && dp[i - 1][j] == dp[i][j])
                backtrack(s1, s2, i - 1, j, dp, path, result);
            if (dp[i][j - 1] != null && dp[i][j - 1] == dp[i][j])
                backtrack(s1, s2, i, j - 1, dp, path, result);
        }
    }
}
