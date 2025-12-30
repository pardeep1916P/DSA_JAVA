class Solution {

    /*
      To Lower Case — Built-in Method Approach

      Approach:
      - Directly use Java's built-in toLowerCase() method.
      - The method converts all uppercase characters to lowercase
        according to Unicode rules.

      Time  : O(n) — processes each character once
      Space : O(n) — returns a new string (strings are immutable)

      Note:
      This is the cleanest and safest approach in real-world code.
      In some interviews, built-in methods may be restricted,
      in which case a manual ASCII-based solution is expected.
    */

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
