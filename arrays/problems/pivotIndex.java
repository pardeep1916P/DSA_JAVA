//my approach
public int pivotIndex(int[] nums) {
    if (nums.length == 0) return -1;

    int before = 0, after = 0;
    int n = nums.length;
    int i = n - 1;

    //Calculate total sum in after
    while (i >= 0) after += nums[i--];

    //reset i → 0
    i = 0;

    //Move i from left → right
    while (i < n) {
        after -= nums[i]; //remove pivot element as it is not included
        if (before == after) return i; // check if left and right sums are equal
        before += nums[i]; // add left most new element to before
        i++;
    }

    return -1;
}