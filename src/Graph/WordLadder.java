package Graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Step 1: wordList ko Set mein convert kar diya for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // Step 2: agar endWord list mein hi nahi hai to return 0
        if (!wordSet.contains(endWord)) return 0;

        // Step 3: Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);  // BFS start hota hai beginWord se
        int level = 1;           // Start level is 1 (beginWord count hota hai)

        // Step 4: BFS start
        while (!queue.isEmpty()) {
            int size = queue.size();  // Current level ke elements count

            // Har level ke saare words process karenge
            for (int i = 0; i < size; i++) {
                String word = queue.poll();   // Current word
                char[] wordArr = word.toCharArray();

                // Har character ko 'a' to 'z' tak replace karke dekhenge
                for (int j = 0; j < wordArr.length; j++) {
                    char originalChar = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        // Agar match ho gaya endWord se
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // Agar valid word mila jo list mein hai
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);       // Queue mein daal do
                            wordSet.remove(newWord);    // Use hata do taaki revisit na ho
                        }
                    }

                    // Backtrack: character ko wapas original bana do
                    wordArr[j] = originalChar;
                }
            }

            // Next level pe chale jao
            level++;
        }

        // Agar kabhi endWord mila hi nahi
        return 0;
    }
}
