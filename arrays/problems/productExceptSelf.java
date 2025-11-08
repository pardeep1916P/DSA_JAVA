public int[] productExceptSelf(int[] nums) {
    if (nums.length == 0) return nums; //base case for empty array
    int product = 1,count = 0;
    for(int i:nums){
        if(i!=0) product*=i; //to find product of all elements except zero element
        else count++; //if found a zero element count increment
    }
    for(int i=0;i<nums.length;i++){
        if(count>1) nums[i]=0; //more than 1 zero means every element will be zero
        else if(count==1) nums[i] = (nums[i]==0)? product : 0; //one zero so every element will be zero except the one
        else nums[i] = product/nums[i]; //if there are no zeros
    }
    return nums;
}