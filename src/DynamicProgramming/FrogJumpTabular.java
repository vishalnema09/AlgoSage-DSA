package DynamicProgramming;

public class FrogJumpTabular {
    int minCost(int[] height) {
        int n = height.length;
        int []dp = new int[n];
        dp[0]= 0;
        for(int i =1;i<n;i++){
            int left = dp[i-1] + Math.abs(height[i]-height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = dp[i-2] + Math.abs(height[i]- height[i-2]);
            }
            dp[i]= Math.min(left,right);
        }
        return dp[n-1];
    }
}
