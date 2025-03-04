package String;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String conc = s+s;
        String check = conc.substring(1, conc.length()-1);
        return check.contains(s);
    }
}
