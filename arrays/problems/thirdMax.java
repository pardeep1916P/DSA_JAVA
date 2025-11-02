public int thirdMax(int[] nums) {
    long first =Long.MIN_VALUE;
    long second =Long.MIN_VALUE;
    long third =Long.MIN_VALUE ;

    for (int n : nums) {
        if (n > first) { //if n is largest
            third = second;
            second = first;
            first = n;
        } else if (n > second && n != first) { //if n is second highest
            third = second;
            second = n;
        } else if(n >third && n !=second && n != first){ //if n is third highest
            third = n;
        }
    }
    return (int) (third == Long.MIN_VALUE ? first : third);
}