import java.util.HashMap;
import java.util.Objects;

class Solution {

    /*
      Word Pattern — Single HashMap with Index Mapping (Optimal Solution)

      Approach:
      - Use a single HashMap<Object, Integer> to store the last seen index
        of both pattern characters and words.
      - Traverse pattern and words together:
            • Insert (character → index) into the map.
            • Insert (word → index) into the map.
      - If the previous index of the character and the word differ,
        the mapping is inconsistent → return false.
      - Objects.equals() safely compares null and integer values.

      Time  : O(n)
              n = length of pattern / number of words
      Space : O(n)
              due to storing characters and words in the map

      Note:
      This solution enforces a strict one-to-one mapping
      using a single data structure and is considered optimal.
    */

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Pattern length and word count must match
        if (words.length != pattern.length()) return false;

        HashMap<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // Compare last seen indices of character and word
            if (!Objects.equals(map.put(ch, i), map.put(word, i))) return false;
        }

        return true;
    }
}
