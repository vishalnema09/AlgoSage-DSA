package DynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber {
    public int fib(int n) {
        int []dp = new int [n+1];
        Arrays.fill(dp,-1);
        return helper (n, dp);
    }
    public int helper(int n,int []dp){
        if(n<=1)return n;
        if(dp[n]!= -1)return dp[n];
        return dp[n]= helper(n-1,dp)+ helper(n-2,dp);
    }
}
