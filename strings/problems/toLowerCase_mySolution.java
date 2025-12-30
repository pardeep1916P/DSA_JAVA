class Solution {

    /*
      To Lower Case — ASCII Based Conversion (my Solution)

      Approach:
      - Convert the string into a character array for in-place modification.
      - For each character:
            • Check if it lies in the ASCII range of uppercase letters (A–Z).
            • If yes, convert it to lowercase by adding 32 to its ASCII value.
      - Return the modified string.

      Time  : O(n) — each character processed once
      Space : O(n) — character array created from the string

      Note:
      This solution uses ASCII value manipulation instead of built-in methods.
    */

    public String toLowerCase(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            // Check if character is an uppercase letter (ASCII 65–90)
            if ((int) arr[i] < 91 && (int) arr[i] > 64)
                arr[i] = (char) ((int) arr[i] + 32);  // Convert to lowercase
        }

        return new String(arr);
    }
}
