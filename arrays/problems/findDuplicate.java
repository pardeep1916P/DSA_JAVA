//floyd's algorithm approach
public int findDuplicate(int[] nums) {
    if(nums.length == 0) return 0;
    int slow=0,fast=0; // assign pointers to starting index
    //loop runs until cycle detected
    while(true){
        slow = nums[slow];
        fast = nums[nums[fast]];
        if(slow == fast) break;
    }
    slow = 0; //moving pointer to starting index
    while(slow != fast){ //moving two pointers parallely
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}