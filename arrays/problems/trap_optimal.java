class Solution {

    /*
      Trapping Rain Water — Two Pointer Technique (Optimal Solution)

      Approach:
      - Use two pointers starting from both ends of the array.
      - Maintain:
            lmax → maximum height seen so far from the left
            rmax → maximum height seen so far from the right
      - At each step:
            • Compare lmax and rmax.
            • The side with the smaller maximum determines
              how much water can be trapped.
      - Move the pointer from the side with the smaller max,
        because water level there is bounded by that max.

      Key Insight:
      - Water trapped at any index depends only on the smaller
        of the left and right maximum heights.
      - No extra arrays are required.

      Time  : O(n) — single pass using two pointers
      Space : O(1) — constant extra space

      Note:
      This is the most optimal solution for the trapping rain water problem.
    */

    public int trap(int[] height) {

        int n = height.length;

        // Less than 3 bars cannot trap water
        if (n < 3) return 0;

        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        int res = 0;

        while (l < r) {

            // Update maximums seen so far from both ends
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            // Water trapped depends on the smaller boundary
            res += (lmax<rmax)? lmax-height[l++] : rmax-height[r--];
        }

        return res;
    }
}
