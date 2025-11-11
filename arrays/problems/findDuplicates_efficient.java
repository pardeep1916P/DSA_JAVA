//most efficient code using negative marking
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> duplicates = new ArrayList<>(); //result list of duplicates
    for(int i:nums){
        i = Math.abs(i);  //handling case if the i is already negative
        if(nums[i-1]<0) duplicates.add(i); //if the element i is duplicate then add to resulting list
        nums[i-1] = -nums[i-1]; //making the element at i th index negative(marked as visited)
    }
    return duplicates;
}