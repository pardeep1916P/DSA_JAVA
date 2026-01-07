import java.util.HashSet;

class Solution {

    /*
      Jewels and Stones — HashSet Lookup Approach (Optimal Solution)

      Approach:
      - Store all jewel characters in a HashSet for fast lookup.
      - Traverse the stones string and count characters
        that are present in the jewel set.
      - Each lookup in the set takes constant time.

      Time  : O(j + s)
              j = length of jewels
              s = length of stones
      Space : O(j) — HashSet stores jewel characters

      Note:
      This approach avoids nested loops and provides
      efficient membership checking.
    */

    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();
        int count = 0;

        // Add all jewel characters to the set
        for (char c : jewels.toCharArray())
            set.add(c);

        // Count stones that are jewels
        for (char c : stones.toCharArray())
            if (set.contains(c))
                count++;

        return count;
    }
}
