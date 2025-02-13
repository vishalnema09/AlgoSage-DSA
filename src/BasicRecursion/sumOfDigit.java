package BasicRecursion;

public class sumOfDigit {
    static int sumOfDigits(int n) {
        // Base Condition
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}
