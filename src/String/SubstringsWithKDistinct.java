package String;

import java.util.HashMap;

public class SubstringsWithKDistinct {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private int atMostKDistinct(String s, int K) {
        if (K < 0) return 0;
        int left = 0, count = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            while (freqMap.size() > K) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++; // Window shrink karna
            }

            count += (right - left + 1);
        }

        return count;
    }
}
