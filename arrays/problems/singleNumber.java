public int singleNumber(int[] nums) {
    if(nums == null) return -1; //base case empty check
    int result=0;
    for(int num:nums) result^=num; //XOR operation for consecutive elements
    return result;
}