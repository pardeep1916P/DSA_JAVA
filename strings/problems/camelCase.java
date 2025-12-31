 /*
      CamelCase — Uppercase Letter Counting (Optimal Solution)

      Approach:
      - In a valid camelCase string:
            • The first word starts with a lowercase letter.
            • Every new word starts with an uppercase letter.
      - So, the total number of words equals:
            1 + number of uppercase letters in the string.
      - Traverse the string once and count uppercase characters
        using their ASCII range.

      Time  : O(n) — single pass through the string
      Space : O(1) — constant extra space

      Note:
      This solution avoids splitting the string and does not use
      any additional data structures.
    */

    public static int camelcase(String s) {

        int n = s.length();

        // Empty string → no words
        if (n == 0) return 0;

        int count = 1;  // First word always exists
        int i = 0;

        while (i < n) {

            int ascii = (int) s.charAt(i++);

            // ASCII range for uppercase letters (A–Z)
            if (ascii >= 65 && ascii <= 90)
                count++;
        }

        return count;
    }
