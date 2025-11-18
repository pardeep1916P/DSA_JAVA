//most efficient one loop approach
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length-1;//three pointers approach
    //swapping using mid pointers
    while(mid <= high){
        if(nums[mid] == 0) swap(nums,low++,mid++);//move 0's to low
        else if(nums[mid] == 1) mid++; //leave 1's as it is
        else swap(nums,mid,high--); //move 2's to high
    }
    return;
}
//helper method to swap
private void swap(int[] arr, int x, int y){
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
    return;
}