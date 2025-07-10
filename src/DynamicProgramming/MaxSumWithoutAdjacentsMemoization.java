package DynamicProgramming;

import java.util.Arrays;

public class MaxSumWithoutAdjacentsMemoization {
    public int solve(int i , int[]arr, int []dp){
        if(i < 0) return 0;
        if(i == 0) return arr[i];
        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + solve(i-2, arr, dp);
        int notPick = solve(i-1, arr, dp);

        return dp[i] = Math.max(pick, notPick);
    }
    int findMaxSum(int arr[]) {
        int n = arr.length;
        int []dp = new int [n];
        Arrays.fill(dp,-1);
        return solve(n-1,arr,dp);
    }
}
