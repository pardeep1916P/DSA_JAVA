/*
Problem: Longest Consecutive Sequence (LC128)

Idea:
Use a HashSet so we can quickly check if a number and its next number exist.

Why this works:
We only start counting when a number has no previous number (n - 1),
which means it's the actual beginning of a sequence.

Complexity:
Time  – O(n)
Space – O(n)

Edge Cases:
- Empty input → return 0
- All duplicates → longest is 1
*/

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers for O(1) existence checks
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        // Tracks the longest consecutive sequence found
        int max = 0;

        // Loop through each unique number
        for (int i : set) {

            // Only start counting if 'i' is the beginning of a sequence
            if (!set.contains(i - 1)) {
                int curr = i;
                int count = 1;

                // Move forward through consecutive numbers
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                // Update the maximum sequence length
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
