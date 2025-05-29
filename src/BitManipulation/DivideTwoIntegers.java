package BitManipulation;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Step 1: Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Step 2: Convert to long and take absolute values
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        // Step 3: Subtract divisor using powers of 2 (bit shifting)
        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        // Step 4: Apply sign
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}
