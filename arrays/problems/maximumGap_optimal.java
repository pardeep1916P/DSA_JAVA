import java.util.Arrays; //optional for leetcode

class Solution {

    /*
      Maximum Gap — Bucket Based Approach (Optimal Solution)

      Approach:
      - The maximum gap will NOT be between elements inside the same bucket,
        but between the maximum of one bucket and the minimum of the next non-empty bucket.
      - Use the Pigeonhole Principle:
            * If n numbers are spread between min and max,
              at least one gap must be ≥ ceil((max - min) / (n - 1)).
      - Create n-1 buckets, each tracking:
            • minimum value in the bucket
            • maximum value in the bucket
      - Distribute numbers into buckets and then scan buckets to compute the maximum gap.

      Time  : O(n) — single pass for bucket filling + single pass for gap calculation
      Space : O(n) — bucket arrays

      Note:
      This is the most optimal solution for the Maximum Gap problem.
    */

    public int maximumGap(int[] nums) {

        int n = nums.length;

        // Less than two elements → no gap possible
        if (n < 2) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find global minimum and maximum
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // All elements are equal → gap is zero
        if (min == max) return 0;

        // Minimum possible maximum gap (bucket size)
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));

        // Buckets to store min and max values
        int[] minOfBucket = new int[n - 1];
        int[] maxOfBucket = new int[n - 1];

        Arrays.fill(minOfBucket, Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, Integer.MIN_VALUE);

        // Distribute elements into buckets
        for (int i = 0; i < n; i++) {

            // Skip global min and max
            if (nums[i] == min || nums[i] == max) continue;

            int idx = (nums[i] - min) / bucketSize;

            minOfBucket[idx] = Math.min(minOfBucket[idx], nums[i]);
            maxOfBucket[idx] = Math.max(maxOfBucket[idx], nums[i]);
        }

        int maxGap = 0;

        // Compute maximum gap between consecutive non-empty buckets
        for (int i = 0; i < n - 1; i++) {

            // Skip empty buckets
            if (maxOfBucket[i] == Integer.MIN_VALUE) continue;

            // Gap between current bucket min and previous bucket max
            maxGap = Math.max(minOfBucket[i] - min, maxGap);

            // Update previous max
            min = maxOfBucket[i];
        }

        // Final gap between last bucket and global max
        maxGap = Math.max(maxGap, max - min);

        return maxGap;
    }
}
