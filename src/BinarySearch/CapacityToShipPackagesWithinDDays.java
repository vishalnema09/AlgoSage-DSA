package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
    public int findDays(int[] arr, int cap) {
        int count = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + load > cap) {
                count++;
                load = arr[i];
            } else
                load += arr[i];
        }
        return count;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i =0;i<weights.length;i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            int numberOfDays = findDays(weights, mid);
            if(numberOfDays <= days){
                high= mid -1;
            }
            else low = mid +1;
        }
        return low;
    }
}
