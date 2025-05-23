package SlidingWindow;

public class NumberSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int []count = {0,0,0};
        int result = 0;
        int i = 0;
        for(int j = 0;j<s.length();j++){
            count[s.charAt(j)- 'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                result+=s.length()-j;
                count[s.charAt(i)-'a']--;
                i++;
            }
        }
        return result;
    }
}
