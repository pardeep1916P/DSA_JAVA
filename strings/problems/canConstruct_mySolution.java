import java.util.HashMap;

class Solution {

    /*
      Ransom Note — HashMap Frequency Tracking (Correct Solution)

      Approach:
      - Count the frequency of each character in the magazine using a HashMap.
      - Traverse the ransomNote:
            • If a character is missing in the map, construction is impossible.
            • Decrease the frequency for each used character.
            • Remove the character from the map when its frequency reaches zero.
      - If all characters are successfully matched, return true.

      Time  : O(m + n)
              m = length of magazine
              n = length of ransomNote
      Space : O(k) — number of unique characters in magazine

      Note:
      This solution is clear and correct, but uses extra space
      due to HashMap overhead.
    */

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in magazine
        for (char m : magazine.toCharArray()) map.put(m, map.getOrDefault(m, 0) + 1);

        // Use characters to form ransomNote
        for (char r : ransomNote.toCharArray()) {

            if (!map.containsKey(r)) return false;

            map.put(r, map.get(r) - 1);

            // Remove character when frequency becomes zero
            if (map.get(r) == 0) map.remove(r);
        }
        return true;
    }
}
