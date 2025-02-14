package Arrays;

public class maxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int maxCount = 0;

        while (right < nums.length) {
            if (nums[right] == 1) {
                maxCount = Math.max(maxCount, right - left + 1);
            } else {
                left = right + 1;
            }
            right++;
        }

        return maxCount;
    }
}
