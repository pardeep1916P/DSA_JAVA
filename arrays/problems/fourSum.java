/*
  4-Sum using Sorting + Two-Pointer Technique

  Approach:
  - Sort the array to efficiently avoid duplicates and use two-pointer scanning.
  - Fix two numbers (i, j) and then find pairs (l, r) such that:
        nums[i] + nums[j] + nums[l] + nums[r] == target
  - Skip duplicates at each level to ensure unique quadruplets.

  Time  : O(n^3) — three nested operations (i, j, two-pointer scan)
  Space : O(1)   — ignoring result list; operates in-place after sorting
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);       // Sorting enables two-pointer search and duplicate removal

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements to prevent repeated quadruplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;      // Left pointer
                int r = n - 1;      // Right pointer

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        // Found a valid quadruplet — add to result
                        result.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));

                        // Skip duplicates for the third and fourth numbers
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;

                    }
                    else if (sum < target) l++; // Need a larger sum → move left pointer right

                    else r--; // Need a smaller sum → move right pointer left


                }
            }
        }

        return result;
    }
}
