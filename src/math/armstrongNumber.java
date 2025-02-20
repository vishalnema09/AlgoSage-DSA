package math;

public class armstrongNumber {
    public static boolean isArmstrong(int num) {
        int k = String.valueOf(num).length();
        int sum = 0;
        int n = num;

        while (n > 0) {
            int ld = n % 10;
            sum += Math.pow(ld, k);
            n = n / 10;
        }

        return sum == num;
    }
}
