package Arrays;

import java.util.HashMap;

public class longestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum=0;
        int maxLength=0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            if (prefixMap.containsKey(prefixSum - k)) {
                int prevIndex = prefixMap.get(prefixSum - k);
                maxLength = Math.max(maxLength, i - prevIndex);
            }
            prefixMap.putIfAbsent(prefixSum, i);
        }
        return maxLength;
    }
}
