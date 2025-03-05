package BinarySearch;

public class FloorInSortedArray {
    static int findFloor(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        int floorIndex=-1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(arr[mid]==x){
                floorIndex=mid;
                start =mid+1;
            }
            else if(arr[mid]<x){
                floorIndex = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return floorIndex;
    }
}
