//helper method to reverse between two pointers
private void reverse(int[] arr,int start,int stop){
    //swapping first, last and moving start+1 and stop-1
    while(start<stop){
        int temp = arr[start];
        arr[start] = arr[stop];
        arr[stop] = temp;
        start++;
        stop--;
    }
    return;
}
public void rotate(int[] nums, int k) {
    if(nums.length <2 || k<1) return;
    int n = nums.length;
    k %= n;  //to handle if k>size of the array
    if(k==0) return;
    //reverse first n-k elements
    reverse(nums,0,n-k-1);
    //reverse lask k elements
    reverse(nums,n-k,n-1);
    //reverse entire array to get k rotations result
    reverse(nums,0,n-1);
    return;
}