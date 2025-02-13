package math;

import java.util.Arrays;

public class countPrime {
    public int countPrimes(int n) {
        boolean[] checkPrime = new boolean[n+1];
        Arrays.fill(checkPrime, true);
        int count = 0;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(checkPrime[i]){
                for(int j = i*2; j < n; j+=i){
                    checkPrime[j] = false;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(checkPrime[i])count++;
        }
        return count;
    }
}
