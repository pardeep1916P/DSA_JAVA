package src.arrays.problems;

public static List<Integer> reverseArray(List<Integer> a) {
    if(a.size()==0) return a; //base case
    int left = 0,right = a.size()-1; //initializing two pointers
    while(left < right){  //swap until pointers reach mid
        int temp = a.get(left);
        a.set(left,a.get(right));
        a.set(right,temp);
        left++;   // increment to move forward
        right--; //  decrement to move backward
    }
    return a;
}
