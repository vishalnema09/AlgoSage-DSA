package DynamicProgramming.MatrixChainMultiplicationAndPartition;

public class PalindromePartitioningIIMemo {
    public int minCut(String s) {
        int n = s.length();
        Boolean[][] isPal = new Boolean[n][n];
        Integer[] dp = new Integer[n];

        return solve(0, s, isPal, dp) - 1;
    }

    private int solve(int i, String s, Boolean[][] isPal, Integer[] dp) {
        int n = s.length();
        if (i == n) return 0;
        if (dp[i] != null) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j, isPal)) {
                int cost = 1 + solve(j + 1, s, isPal, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] isPal) {
        if (isPal[i][j] != null) return isPal[i][j];
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPal[i][j] = false;
            }
            i++;
            j--;
        }
        return isPal[i][j] = true;
    }
}
