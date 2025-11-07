public int missingNumber(int[] nums) {
    if(nums.length==0) return 0;
    int n = nums.length,arrSum = 0;
    int sum = n*(n+1)/2; //sum of n natural numbers
    for(int i:nums) arrSum += i; //sum of array elements
    return (sum-arrSum); //return difference of sum of arr and sum of natural numbers
}