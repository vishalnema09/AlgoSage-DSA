package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int subarray = 0;
        for (int i = 0; i < nums.length; i++) {
            subarray += nums[i];
            int diff = subarray - k;
            count += map.getOrDefault(diff, 0);
            map.put(subarray, map.getOrDefault(subarray, 0) + 1);
        }
        return count;
    }
}
