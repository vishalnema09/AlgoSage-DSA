package BinarySearch;

public class MinimumNumberDaysMakeMBouquets {
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int flowers = 0, bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

            if (bouquets >= m)
                return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long totalFlowersNeeded = (long) m * k;
        if (totalFlowersNeeded > n)
            return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
