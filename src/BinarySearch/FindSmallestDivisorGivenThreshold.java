package BinarySearch;

public class FindSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);
        while (left < right) {
            int mid = (left + right) / 2;
            if (getSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getMax(int nums[]) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int getSum(int nums[], int divisor) {
        int sum = 0;
        for (int x : nums) {
            sum += (x + divisor - 1) / divisor;
        }
        return sum;
    }
}
