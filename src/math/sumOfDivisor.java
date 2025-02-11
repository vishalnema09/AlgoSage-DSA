package math;

public class sumOfDivisor {
    public static int sumOfDivisors(int n) {
        // code here
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (n / i) * i;  // (n/i) times i ko add karte hain
        }
        return sum;
    }
}
