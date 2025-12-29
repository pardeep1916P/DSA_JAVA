class Solution {

    /*
      Reverse Vowels of a String — Two Pointer Approach

      Approach:
      - Use two pointers starting from both ends of the string.
      - Move the left pointer until a vowel is found.
      - Move the right pointer until a vowel is found.
      - Swap the vowels and move both pointers inward.
      - Continue until the pointers cross.

      Time  : O(n) — each character is visited at most once
      Space : O(n) — character array created from the string

      Note:
      Only vowels are reversed; all other characters
      remain in their original positions.
    */

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {

        boolean flag = false;

        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            flag = true;

        return flag;
    }

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l < r) {

            // Move left pointer until a vowel is found
            if (!isVowel(arr[l])) {
                l++;

            // Move right pointer until a vowel is found
            } else if (!isVowel(arr[r])) {
                r--;

            // Both pointers are at vowels → swap them
            } else {
                char temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }

        return new String(arr);
    }
}
