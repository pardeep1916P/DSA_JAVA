class Solution {

    /*
      Two Sum II — Two Pointer Technique (Optimal Solution)

      Approach:
      - The array is sorted, so we can use two pointers:
            • left starting at the beginning
            • right starting at the end
      - Calculate the sum of numbers[left] + numbers[right].
      - If the sum equals target → return their 1-based indices.
      - If the sum is smaller than target → move left pointer right.
      - If the sum is greater than target → move right pointer left.
      - Continue until the pointers meet.

      Time  : O(n) — each element processed at most once
      Space : O(1) — constant extra space

      Note:
      - Problem requires returning **1-based indices**.
      - This solution works because the array is already sorted.
    */

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) return new int[]{left + 1, right + 1};  // convert to 1-based index

            else if (sum < target) left++;  // increase sum

            else right--; // decrease sum
        }

        return new int[]{-1, -1}; // fallback (though problem guarantees solution)
    }
}