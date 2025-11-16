public int searchInsert(int[] nums, int target) {
    for(int i=0; i<nums.length; i++) if(nums[i]>=target) return i; //return index if found else first element index of greater value
    return nums.length;
}