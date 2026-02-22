import java.util.*;

class Solution {

    /*
      Group Anagrams — Character Frequency Signature (Optimal Solution)

      Approach:
      - For each string:
            • Build a frequency array of size 26.
            • Construct a unique key based on character counts.
              (Example: "#1#0#0#2...") to avoid ambiguity.
      - Use this key in a HashMap:
            key → list of anagrams
      - Add the string to its corresponding group.
      - Return all grouped values.

      Why this works:
      - Anagrams have identical character frequency distributions.
      - The generated key uniquely represents that distribution.

      Time  : O(n * k)
              n = number of strings
              k = average length of each string
      Space : O(n * k)
              for storing grouped strings

      Note:
      - This avoids sorting each string (which would be O(k log k)).
      - More efficient than the sorting-based approach.
      - `computeIfAbsent` simplifies map initialization.
    */

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Count character frequency
            int[] count = new int[26];

            for (char ch : str.toCharArray()) count[ch - 'a']++;

            // Build unique key from frequency array
            StringBuilder keyBuilder = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                keyBuilder.append("#");
                keyBuilder.append(count[i]);
            }

            String key = keyBuilder.toString();

            // Add string to corresponding anagram group
            map.computeIfAbsent(key, K -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}