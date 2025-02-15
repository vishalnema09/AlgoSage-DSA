package Arrays;

import java.util.Arrays;

public class productOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prefix = 1, suffix = 1;

        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            res[i] *= prefix;
            prefix *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
