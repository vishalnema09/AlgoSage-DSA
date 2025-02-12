package BasicRecursion;

public class printWordNtime {
    void printGfg(int N) {
        if(N==0){
            return;
        }
        System.out.print("GFG ");
        printGfg(N-1);
    }
}
