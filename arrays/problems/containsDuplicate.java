class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(); //to store unique value
        for(int i:nums){
            if(set.contains(i)) return true; //if number repeats
            set.add(i);  //if number is unique add
        }

        return false;
    }
}
