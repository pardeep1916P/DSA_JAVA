class Solution {

    /*
      Search in Rotated Sorted Array II — Modified Binary Search (Optimal Solution)

      Approach:
      - Use binary search, but handle duplicates carefully.
      - At each step:
            1. Check if mid element is the target.
            2. Determine which half is sorted.
            3. Decide whether the target lies in the sorted half.
            4. Narrow the search range accordingly.
      - When nums[l] == nums[mid], we cannot determine the sorted half
        due to duplicates, so we safely move l forward by one.

      Time  : O(log n) on average, O(n) in the worst case (all duplicates)
      Space : O(1) — constant extra space

      Note:
      This is the most optimal approach for handling rotation with duplicates.
    */

    public boolean search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            // Found the target
            if (nums[mid] == target) return true;

            // Left half is strictly sorted
            if (nums[l] < nums[mid]) {

                // Target lies within the left sorted half
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;

                else l = mid + 1;
            }

            // Right half is strictly sorted
            else if (nums[l] > nums[mid]) {

                // Target lies within the right sorted half
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;

                else r = mid - 1;
            }

            // nums[l] == nums[mid] → cannot determine sorted half
            // Move left pointer forward to skip duplicate
            else l++;

        }

        return false; // Target not found
    }
}
