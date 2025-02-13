package BasicRecursion;

import java.util.ArrayList;

public class factorialToNth {
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> result = new ArrayList<>();
        long fact = 1;
        long i = 1;

        while (fact <= n) {
            result.add(fact);
            i++;
            fact *= i;
        }

        return result;
    }
}
