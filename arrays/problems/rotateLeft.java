package src.arrays.problems;
//time-O(n) space-O(1)
//helper method to reverse array from start index to end index
public static void reverse(List<Integer> arr,int start,int end){
    while(start<end){
        int temp = arr.get(start);
        arr.set(start,arr.get(end));
        arr.set(end,temp);
        start++;
        end--;
    }
}

public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    int n = arr.size();
    d = d%n;
    //reverse first d elements
    reverse(arr,0,d-1);
    //reverse remaining elements
    reverse(arr,d,n-1);
    //reverse entire list for expected placing
    reverse(arr,0,n-1);
    return arr;
}