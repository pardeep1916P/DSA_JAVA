class Solution {

    /*
      Ransom Note — Fixed Frequency Array (Most Optimal Solution)

      Approach:
      - Use a fixed-size frequency array of length 26
        since the input contains only lowercase English letters.
      - Count the frequency of each character in the magazine.
      - Traverse the ransomNote:
            • Decrement the corresponding frequency.
            • If any frequency becomes negative, return false.
      - If all characters are available, return true.

      Time  : O(m + n)
              m = length of magazine
              n = length of ransomNote
      Space : O(1) — constant space (26-sized array)

      Note:
      This is the most optimal solution for interviews
      due to minimal space usage and no hashing overhead.
    */

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count characters in magazine
        for (char m : magazine.toCharArray()) freq[m - 'a']++;

        // Check availability for ransomNote
        for (char r : ransomNote.toCharArray()) if (--freq[r - 'a'] < 0) return false;

        return true;
    }
}
