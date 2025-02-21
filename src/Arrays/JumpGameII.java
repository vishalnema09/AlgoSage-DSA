package Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int farthest=0;
        int currEnd=0;
        for (int i=0;i<n-1;i++){
            farthest= Math.max(farthest, i+nums[i]);
            if(i==currEnd){
                jumps++;
                currEnd= farthest;

                if(currEnd>=n-1)break;
            }
        }
        return jumps;
    }
}
