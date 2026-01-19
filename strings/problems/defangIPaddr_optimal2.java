class Solution {

    /*
      Defanging an IP Address — Manual Character Processing (Optimal Solution 2)

      Approach:
      - Traverse the input string character by character.
      - When a dot '.' is encountered, append "[.]".
      - Otherwise, append the character as-is.
      - Use StringBuilder for efficient string construction.

      Time  : O(n) — single pass through the string
      Space : O(n) — StringBuilder used to build result

      Note:
      This solution avoids built-in string replacement
      and is preferred when such methods are restricted in interviews.
    */

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();

        for (char ch : address.toCharArray()) {

            if (ch == '.') sb.append("[.]");
            else sb.append(ch);
        }

        return sb.toString();
    }
}
