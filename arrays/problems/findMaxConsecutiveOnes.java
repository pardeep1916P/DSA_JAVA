public int findMaxConsecutiveOnes(int[] nums) {
    if(nums.length==0) return 0;
    int count = 0,max = 0;
    for(int i:nums){
        count = (i==1)? (count+1) : 0; //to count consecutive 1's and assign 0 if rule breaks
        max = (count>max)? count : max; //find maximum among previous maximum and current count;
    }
    return max;
}