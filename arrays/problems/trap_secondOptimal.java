class Solution {

    /*
      Trapping Rain Water — Prefix Maximum Arrays (Second Optimal Solution)

      Approach:
      - Water trapped at index i depends on the minimum of:
            max height to the left of i
            max height to the right of i
      - Precompute:
            lmax[i] → maximum height from index 0 to i
            rmax[i] → maximum height from index n-1 to i
      - For each index i:
            trapped water = min(lmax[i], rmax[i]) - height[i]
      - Sum trapped water over all indices.

      Time  : O(n) — three linear passes
      Space : O(n) — extra arrays for left and right maximums

      Note:
      This is the second optimal solution.
      The most optimal approach uses two pointers → O(1) space.
    */

    public int trap(int[] height) {

        int n = height.length;

        // Less than 3 bars cannot trap water
        if (n < 3)
            return 0;

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        // Initialize boundary values
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];

        // Build prefix maximums from the left
        for (int i = 1; i < n; i++) lmax[i] = Math.max(lmax[i - 1], height[i]);

        // Build prefix maximums from the right
        for (int j = n - 2; j >= 0; j--) rmax[j] = Math.max(rmax[j + 1], height[j]);

        int res = 0;

        // Calculate trapped water at each index
        for (int i = 0; i < n; i++) res += Math.min(lmax[i], rmax[i]) - height[i];

        return res;
    }
}
