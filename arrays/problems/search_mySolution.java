class Solution {

    /*
      Search in Rotated Sorted Array — Direction-Based Linear Scan (Brute Force Variant)

      Approach:
      - First check if the array has only one element.
      - Decide which sorted segment to search:
            • If target >= nums[first] → search from the left side
            • Else                     → search from the right side
      - While scanning:
            • If an element breaks the sorted property of the chosen segment,
              we stop early and return -1.
            • If we find the target, return its index.

      Time  : O(n) — potentially scans the entire array
      Space : O(1) — constant extra space

      Note:
      This solution is valid but not optimal.
      The optimal approach uses binary search → O(log n).
    */

    public int search(int[] nums, int target) {

        // Special case: single element array
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;


        int first = 0;
        int last = nums.length;

        // If target is in the left (non-rotated) segment
        if (target >= nums[first]) {

            // Scan from the start forward
            for (int i = 0; i < last; i++) {

                // Found target
                if (nums[i] == target) return i;

                    // If sorted order breaks, target cannot exist further
                else if (i != first && nums[i] < nums[i - 1]) return -1;
            }
        }

        // Otherwise target should lie in the right sorted segment
        else {

            // Scan from the end backwards
            for (int j = last - 1; j > 0; j--) {

                // Found target
                if (nums[j] == target) return j;

                    // If sorted order breaks, no need to continue
                else if (j != last - 1 && nums[j] > nums[j + 1]) return -1;
            }
        }

        // If not found in either scan
        return -1;
    }
}
