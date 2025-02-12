package BasicRecursion;

public class printNos {
    public void printNo(int n) {
        if(n==0){
            return ;
        }
        printNo(n-1);
        System.out.print(n + " ");
    }
}
