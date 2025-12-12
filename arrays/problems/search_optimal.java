class Solution {

    /*
      Search in Rotated Sorted Array — Binary Search (Optimal Solution)

      Approach:
      - Use modified binary search because one half of a rotated sorted array
        is always fully sorted.
      - At each step:
            1. Check if nums[mid] is the target.
            2. Determine which half (left or right) is sorted.
            3. Decide if the target lies inside the sorted half.
            4. If yes → move search into that half.
               If no  → search the other half.

      Time  : O(log n) — binary search halving the search space each step
      Space : O(1)     — constant extra space
    */

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Found the target
            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies within the left sorted range
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;

                // Otherwise search the right half
                else left = mid + 1;
            }

            // Right half is sorted
            if (nums[mid] <= nums[right]) {

                // Target lies within the right sorted range
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;

                // Otherwise search the left half
                else right = mid - 1;
            }
        }

        return -1;  // Target not found
    }
}
