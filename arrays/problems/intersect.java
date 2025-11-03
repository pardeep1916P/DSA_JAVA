class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[] {};
        HashMap<Integer,Integer> map = new HashMap<>(); //hashmap to store frequency of each element
        for(int i:nums1) map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<Integer> list = new ArrayList<>(); //hashmap to store common elements
        //add each element in common with frequency handling
        for(int i:nums2){
            if(map.containsKey(i)){
                list.add(i);
                map.put(i,map.get(i)-1);
                if(map.get(i)==0) map.remove(i); //if the frequency of an element is 0 should be deleted
            }
        }
        int[] result = new int[list.size()];
        //to convert ArrayList to return type
        for(int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;

    }
}