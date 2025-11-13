public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>(); //initializing resultant list to return
    int n = nums.length/3;   //calcutating 1 3rd of the array
    HashMap<Integer,Integer> map = new HashMap<>();  //hashmap to check the count of the elements
    for(int i:nums){
        map.put(i,map.getOrDefault(i,0)+1);  //updating hashmap with element count
        if(map.get(i)>n && !result.contains(i)) result.add(i); //if element already seen more than n times
    }
    return result;
}