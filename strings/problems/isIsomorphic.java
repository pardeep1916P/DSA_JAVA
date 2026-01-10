class Solution {

    /*
      Isomorphic Strings — Bidirectional Mapping Using Arrays (Optimal Solution)

      Approach:
      - Two strings are isomorphic if characters from one string
        can be mapped to characters of the other string in a one-to-one manner.
      - Use two arrays:
            • ST → maps characters from s to t
            • TS → maps characters from t to s
      - Traverse both strings simultaneously:
            • If neither character has been mapped, create the mapping.
            • If a mapping exists, ensure it is consistent.
      - If any inconsistency is found, the strings are not isomorphic.

      Time  : O(n) — single pass through both strings
      Space : O(1) — fixed-size arrays (256 ASCII characters)

      Note:
      This approach avoids HashMaps and provides constant-time lookups.
    */

    public boolean isIsomorphic(String s, String t) {

        // Length mismatch → cannot be isomorphic
        if (s.length() != t.length())
            return false;

        int[] ST = new int[256]; // mapping from s → t
        int[] TS = new int[256]; // mapping from t → s

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // No mapping exists yet → create mapping in both directions
            if (ST[c1] == 0 && TS[c2] == 0) {
                ST[c1] = c2;
                TS[c2] = c1;
            }

            // Existing mapping must be consistent
            else if (ST[c1] != c2 || TS[c2] != c1) return false;
        }

        return true;
    }
}
