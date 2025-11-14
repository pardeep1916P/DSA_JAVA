public int pivotIndex(int[] nums) {
    if(nums.length == 0) return -1;
    int total = 0;
    for(int i:nums) total+=i;
    int left = 0;
    for(int i=0; i<nums.length; i++){
        if(left == total-nums[i]-left) return i;
        left+=nums[i];
    }
    return -1;
}