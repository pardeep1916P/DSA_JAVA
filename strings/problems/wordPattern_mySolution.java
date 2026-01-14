import java.util.HashMap;

class Solution {

    /*
      Word Pattern — Bidirectional Mapping (Own Solution)

      Approach:
      - Split the input string into words.
      - If the number of words does not match the pattern length,
        a valid mapping is impossible.
      - Use two mappings to enforce a one-to-one relationship:
            • CTSmap (char → string) using an array of size 26
            • STCmap (string → char) using a HashMap
      - Traverse pattern and words together:
            • Ensure each character always maps to the same word.
            • Ensure each word always maps to the same character.
      - If any inconsistency is found, return false.

      Time  : O(n)
              n = length of the pattern / number of words
      Space : O(n)
              due to storing mappings for words

      Note:
      This bidirectional check prevents many-to-one
      or one-to-many mappings.
    */

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Pattern length and word count must match
        if (words.length != pattern.length()) return false;

        String[] CTSmap = new String[26];           // char → string mapping
        HashMap<String, Character> STCmap = new HashMap<>(); // string → char mapping

        for (int i = 0; i < pattern.length(); i++) {

            int index = pattern.charAt(i) - 'a';
            String word = words[i];
            char ch = pattern.charAt(i);

            // Check char → string mapping
            if (CTSmap[index] == null) CTSmap[index] = word;

            else if (!CTSmap[index].equals(word)) return false;

            // Check string → char mapping
            if (!STCmap.containsKey(word)) STCmap.put(word, ch);

            else if (STCmap.get(word) != ch) return false;
        }

        return true;
    }
}
