package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            backtrack(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(String s, int start, List<String> curr, List<List<String>> result) {
            if (start == s.length()) {
                result.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    curr.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, curr, result);
                    curr.remove(curr.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right))
                    return false;
                left++;
                right--;
            }
            return true;
        }
    }
}
