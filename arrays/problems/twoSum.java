public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>(); //to store value and index pairs as map
    for(int i=0;i<nums.length;i++){
        int complement = target-nums[i];
        if(map.containsKey(complement)) return new int[] {map.get(complement),i}; //return if the complement is exist
        map.put(nums[i],i); //add new pair
    }
    return new int[]{};  //default return case
}