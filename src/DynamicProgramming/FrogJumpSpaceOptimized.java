package DynamicProgramming;

public class FrogJumpSpaceOptimized {
    int minCost(int[] height) {
        int n = height.length;
        int prev = 0;
        int prev2 = 0;
        for(int i =1;i<n;i++){
            int left = prev + Math.abs(height[i]-height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = prev2 + Math.abs(height[i]- height[i-2]);
            }
            int curr = Math.min(left,right);
            prev2 = prev ;
            prev = curr;
        }
        return prev;
    }
}
