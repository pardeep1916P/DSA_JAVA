import java.util.HashSet;

class Solution {

    /*
      First Missing Positive — HashSet Based Approach (Not Optimal)

      Approach:
      - Track all positive numbers in a HashSet.
      - The first positive integer from 1 to n+1
        that isn’t present in the set is the answer.
        Why n+1?
        Because the smallest missing positive must be
        within the range [1 ... n+1] for n elements.

      Time  : O(n) average — HashSet add & lookup
      Space : O(n) — storing up to all positive values

      Note:
      This solution is simple but not the most optimal.
      The optimal solution uses in-place index marking → O(1) space.
    */

    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store only positive integers
        for (int num : nums) {
            if (num > 0) set.add(num);
        }

        // Find the smallest missing number starting from 1
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1; // This shouldn't be reached realistically
    }
}
