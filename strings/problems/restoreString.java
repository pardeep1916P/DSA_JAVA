class Solution {

    /*
      Shuffle String — Index Mapping Approach (Optimal Solution)

      Approach:
      - Create a character array of the same length as the string.
      - For each position i in the original string:
            • Place s.charAt(i) at index indices[i] in the result array.
      - Convert the character array back to a string and return it.

      Time  : O(n) — each character placed exactly once
      Space : O(n) — auxiliary character array used

      Note:
      This direct index mapping avoids unnecessary swaps
      and is the most efficient approach for this problem.
    */

    public String restoreString(String s, int[] indices) {

        int size = s.length();
        char[] res = new char[size];

        // Place each character at its target index
        for (int i = 0; i < size; i++) res[indices[i]] = s.charAt(i);

        return String.valueOf(res);
    }
}
