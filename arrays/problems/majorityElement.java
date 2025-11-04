//boyer-moore voting algorithm approach
public int majorityElement(int[] nums) {
    if(nums.length == 0) return -1;//base case
    int res = 0 , count = 0;
    for(int n:nums){
        if(count == 0) res = n;  //if frequency became 0 update res
        count += (n == res)? 1:-1; //increment if n = res else decrement
    }
    return res;
}