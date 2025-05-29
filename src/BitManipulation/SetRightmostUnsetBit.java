package BitManipulation;

public class SetRightmostUnsetBit {
    static int setBit(int n) {
        return n | (n + 1);
    }
}
