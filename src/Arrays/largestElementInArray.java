package Arrays;

public class largestElementInArray {
    public static int largest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num:arr){
            if(num>max){
                max=num;
            }
        }
        return max;
    }
}
