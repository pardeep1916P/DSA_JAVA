class Solution {

    /*
      Find K Pairs with Smallest Sums — Min Heap Approach (Optimal Solution)

      Approach:
      - Since nums1 and nums2 are sorted, the smallest pair sums
        always come from combining smaller elements first.
      - Use a min-heap (priority queue) to efficiently extract
        the next smallest sum pair.
      - Initially:
            • Pair each of the first min(k, nums1.length) elements
              of nums1 with nums2[0].
      - Each heap entry stores:
            • nums1 value
            • nums2 value
            • index of nums2 element used
      - After extracting a pair, push the next possible pair
        by advancing in nums2 for the same nums1 element.

      Time  : O(k log k) — heap operations for k pairs
      Space : O(k)       — heap stores at most k elements

      Note:
      This is the most optimal and commonly expected solution
      for the k smallest pairs problem.
    */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        // Handle edge cases
        if (nums1.length == 0 || nums2.length == 0 || k == 0)return res;

        // Min heap ordered by sum of the pair
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // Initialize heap with pairs (nums1[i], nums2[0])
        for (int i = 0; i < Math.min(nums1.length, k); i++)  pq.offer(new int[]{ nums1[i], nums2[0], 0 });

        // Extract k smallest pairs
        while (k-- > 0 && !pq.isEmpty()) {

            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));

            int idx = cur[2];

            // Push next pair using the same nums1 element
            if (idx + 1 < nums2.length) pq.offer(new int[]{ cur[0], nums2[idx + 1], idx + 1 });
        }

        return res;
    }
}
