class Solution {

    /*
      Goal Parser Interpretation — Pattern Matching Traversal (Optimal Solution)

      Approach:
      - Traverse the command string using an index.
      - Interpret patterns based on current character:
            • 'G'    → append "G"
            • "()"   → append "o"
            • "(al)" → append "al"
      - Move the index forward according to the matched pattern length.
      - Use StringBuilder for efficient string construction.

      Time  : O(n) — each character processed once
      Space : O(n) — StringBuilder used for result

      Note:
      This solution avoids using replace or regex
      and directly interprets the command in one pass.
    */

    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < command.length()) {

            // Case: single character 'G'
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;

              // Case: "()"
            } else if (command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
              // Case: "(al)"
            } else {
                sb.append("al");
                i += 4;
            }
        }

        return sb.toString();
    }
}
