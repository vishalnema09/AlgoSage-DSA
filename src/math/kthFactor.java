package math;

public class kthFactor {
    public int kthFactor(int n, int k) {

        int factorPosition = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (factorPosition == k) {
                    return i;
                }
                factorPosition++;
            }
        }
        return -1;
    }
}
