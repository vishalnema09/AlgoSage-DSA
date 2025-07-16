package DynamicProgramming.OnString;

import java.util.*;

public class PrintAllLCSsequencesTab {
    public List<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> result = backtrack(s1, s2, n, m, dp, memo);

        List<String> finalList = new ArrayList<>(result);
        Collections.sort(finalList);
        return finalList;
    }

    private Set<String> backtrack(String s1, String s2, int i, int j, int[][] dp, Map<String, Set<String>> memo) {
        if (i == 0 || j == 0) {
            Set<String> base = new HashSet<>();
            base.add("");
            return base;
        }

        String key = i + "|" + j;
        if (memo.containsKey(key)) return memo.get(key);

        Set<String> result = new HashSet<>();

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            Set<String> temp = backtrack(s1, s2, i - 1, j - 1, dp, memo);
            for (String str : temp)
                result.add(str + s1.charAt(i - 1));
        } else {
            if (dp[i - 1][j] == dp[i][j])
                result.addAll(backtrack(s1, s2, i - 1, j, dp, memo));
            if (dp[i][j - 1] == dp[i][j])
                result.addAll(backtrack(s1, s2, i, j - 1, dp, memo));
        }

        memo.put(key, result);
        return result;
    }
}
