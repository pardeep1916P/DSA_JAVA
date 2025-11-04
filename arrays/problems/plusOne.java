public int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
        if (digits[i] < 9) {  //if digit is <9 just increment in same array
            digits[i]++;
            return digits;
        }
        digits[i] = 0; //if digit = 9 so carry that adition loop runs again
    }
    int[] result = new int[n + 1];  //if all elements are 9 then new array with +1 in size
    result[0] = 1;  //the carry was set in next place
    return result;
}