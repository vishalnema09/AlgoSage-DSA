package BitManipulation;

public class OddOrEven {
    public static void main(String[] args) {
        int num = 7;  // koi bhi number yahan daalo

        if ((num & 1) == 1) {
            System.out.println(num + " is ODD");
        } else {
            System.out.println(num + " is EVEN");
        }
    }
}
