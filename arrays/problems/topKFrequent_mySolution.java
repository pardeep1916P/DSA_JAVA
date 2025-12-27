class Solution {

    /*
      Top K Frequent Elements — Frequency Array + Repeated Scan (Brute Force)

      Approach:
      - First determine the minimum and maximum values in the array
        to size a frequency array that covers the full value range.
      - Use an offset to correctly map negative numbers into the array.
      - Count the frequency of each number.
      - Repeatedly:
            • Scan the frequency array to find the element
              with the current highest frequency.
            • Add it to the result.
            • Set its frequency to zero to avoid reusing it.
      - Repeat this process k times.

      Time  : O(n + k * r)
              where r = (max − min + 1), the value range
      Space : O(r) — frequency array based on value range

      Note:
      This solution is correct but not optimal.
      The optimal solutions use:
            • HashMap + Heap → O(n log k)
            • Bucket Sort     → O(n)
    */

    public int[] topKFrequent(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum values in nums
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        // Offset to handle negative numbers
        int offset = -min;

        // Frequency array covering range [min ... max]
        int[] freq = new int[max - min + 1];

        // Count frequencies
        for (int n : nums) {
            freq[n + offset]++;
        }

        int[] res = new int[k];
        int i = 0;

        // Find top k frequent elements
        while (i < k) {

            int mx = Integer.MIN_VALUE;
            int num = 0;

            // Scan entire frequency array to find max frequency
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] > mx) {
                    mx = freq[j];
                    num = j;
                }
            }

            // Store the element corresponding to the max frequency
            res[i++] = num - offset;

            // Reset frequency so it is not picked again
            freq[num] = 0;
        }

        return res;
    }
}
