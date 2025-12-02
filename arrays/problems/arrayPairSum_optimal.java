/*
  Array Pair Sum — Frequency (Counting Sort) Approach (Optimal Solution)

  Approach:
  - Since values are within [-10000, 10000], we use a fixed-size frequency array.
  - This avoids sorting and allows us to simulate numbers in sorted order.
  - While traversing from smallest to largest, we alternate between:
        • take  → add number to sum (this is the smaller element in a pair)
        • skip → this number is the larger element in a pair
  - This ensures we always pick the minimum from each optimal sorted pair.

  Time  : O(n)     — single scan + fixed range traversal
  Space : O(1)     — frequency array size is constant (20001)

  Note:
  This is the most optimal solution for the given value constraints.
*/

class Solution {

    public int arrayPairSum(int[] nums) {

        // Count frequency of each number in the given range
        int[] freq = new int[20001];
        for (int num : nums) freq[num + 10000]++;

        int sum = 0;
        boolean take = true;   // toggle to decide when to take/skip numbers

        // Traverse through value range in sorted order
        for (int i = 0; i < 20001; i++) {

            // Process each occurrence individually
            while (freq[i] > 0) {

                // Take every alternate number → minimum of each sorted pair
                if (take) sum += (i - 10000);

                take = !take;  // flip decision for next number
                freq[i]--;     // use up one occurrence of this number
            }
        }

        return sum;
    }
}
