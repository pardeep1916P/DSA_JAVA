public int findPeakElement(int[] nums) {
    int peakIndex=0, peakValue=Integer.MIN_VALUE; //peakValue starts from min value to handle -ve inputs
    for(int i=0;i<nums.length;i++){
        if(nums[i] > peakValue){   //check if current element is peak element
            peakIndex = i;         //store index of new peak element
            peakValue = nums[i];   //store value of new peak element
        }
    }
    return peakIndex;
}