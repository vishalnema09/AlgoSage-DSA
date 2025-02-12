package BasicRecursion;

public class printNosReverse {
    public void printNos(int N) {
        // Base case
        if (N == 0)
            return;

        // Print current number
        System.out.print(N + " ");

        // Recursive call with (N - 1)
        printNos(N - 1);
    }
}
