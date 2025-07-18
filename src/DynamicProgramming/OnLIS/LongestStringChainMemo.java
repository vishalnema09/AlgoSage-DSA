package DynamicProgramming.OnLIS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChainMemo {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int max = 1;

        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0));
            }
            dp.put(word, best + 1);
            max = Math.max(max, dp.get(word));
        }
        return max;
    }
}
