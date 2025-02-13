package math;

public class powerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==0)return false;
        if(n%2!=0)return n==1;
        return isPowerOfTwo(n/2);
    }
}
