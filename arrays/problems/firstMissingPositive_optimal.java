/*
  First Missing Positive — In-Place Index Mapping (Optimal Solution)

  Approach:
  - The smallest missing positive must lie within [1 ... n+1].
  - We rearrange the array so each value x (if valid) is placed
        at index x-1  → nums[x-1] = x
  - We repeatedly swap elements into their correct positions.
  - After placement:
        * If nums[i] != i+1 → i+1 is the first missing positive
        * If all are correct → answer is n+1

  Time  : O(n) — each element swapped at most once
  Space : O(1) — in-place rearrangement, no extra data structures

  This is the most optimal solution for interviews.
*/
class Solution {

    // Swap utility
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct index position if possible
        for (int i = 0; i < n; i++) {

            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);

        }

        // Identify the first index where value is mismatched
        for (int i = 0; i < n; i++) if (nums[i] != i + 1) return i + 1;

        // If all correct, the missing number is n+1
        return n + 1;
    }
}
