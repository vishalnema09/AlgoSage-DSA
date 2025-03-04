package String;

import java.util.ArrayList;

public class KeyboardRow {
    public boolean isRow(String s, String row) {
        for(char ch : s.toCharArray()) {
            if(row.indexOf(Character.toLowerCase(ch)) == -1) {
                return false;
            }
        }
        return true;
    }

    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        for(String word : words) {
            if(isRow(word, row1) || isRow(word, row2) || isRow(word, row3)) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}
