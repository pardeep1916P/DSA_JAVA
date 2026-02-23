import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {

    /*
      Find All Anagrams in a String — Sliding Window with Frequency Arrays (Optimal Solution)

      Approach:
      - If p is longer than s, no anagrams are possible.
      - Build a frequency array (pCount) for string p.
      - Use a sliding window of size plen over string s.
      - Maintain another frequency array (window) for the current window.
      - For each step:
            • Add the current character to the window.
            • If window size exceeds plen, remove leftmost character.
            • When window size equals plen, compare frequency arrays.
            • If equal, add left index to result.

      Time  : O(n * 26) ≈ O(n)
              n = length of s
              (Arrays.equals compares 26 elements — constant)
      Space : O(1)
              Two fixed-size arrays of length 26

      Note:
      - This is the standard interview-expected sliding window solution.
      - Using fixed-size arrays makes comparison constant time.
    */

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int slen = s.length(), plen = p.length();
        if (plen > slen) return result;

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Build frequency for p
        for (char ch : p.toCharArray()) pCount[ch - 'a']++;

        int l = 0;

        for (int r = 0; r < slen; r++) {

            // Add current character to window
            window[s.charAt(r) - 'a']++;

            // Maintain window size = plen
            if (r - l + 1 > plen) window[s.charAt(l++) - 'a']--;

            // Compare when window size matches plen
            if (r - l + 1 == plen && Arrays.equals(pCount, window)) result.add(l);
        }

        return result;
    }
}